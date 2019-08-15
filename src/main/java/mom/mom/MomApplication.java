package mom.mom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MomApplication {

    public static void main(String[] args) {
        SpringApplication.run(MomApplication.class, args);
        String pass = "test123";

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String chip = passwordEncoder.encode(pass);

        System.out.println("pass = " + chip);
        System.out.println("-----RUNNING-------");
    }

}
