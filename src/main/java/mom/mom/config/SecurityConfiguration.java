/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author HARRY-PC
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private LoginSuccessHendler successHendler;
    
    @Autowired
    private LoginAccessDeniedHandler accessDeniedHandler;
    
    @Autowired
    private DataSource dataSource;
    
    private static final String SQL_ROLE
            = "SELECT emp.email as username, r.name as authority "
            + "FROM employee emp "
            + "INNER JOIN role r "
            + "ON emp.role = r.id "
            + "WHERE emp.email = ? ";
    
    private static final String SQL_LOGIN
            = "SELECT email, password, isactive "
            + "FROM employee "
            + "WHERE email = ? ";

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
    
    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());
        
        return provider;
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    @Override
    public UserDetailsService userDetailsService(){
        JdbcDaoImpl userDetails = new JdbcDaoImpl();
        userDetails.setDataSource(dataSource);
        userDetails.setUsersByUsernameQuery(SQL_LOGIN);
        userDetails.setAuthoritiesByUsernameQuery(SQL_ROLE);
        return userDetails;
    }
    
    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/scss/**").permitAll()
                .antMatchers("/vendor/**").permitAll()
                .antMatchers("/dashboard").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .antMatchers("/pic/**").hasAnyAuthority("PIC")
                .antMatchers("/manager/**").hasAnyAuthority("MANAGER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("txtEmail")
                .passwordParameter("txtPassword")
                .successHandler(successHendler)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
    
}
