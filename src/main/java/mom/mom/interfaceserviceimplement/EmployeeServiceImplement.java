/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceserviceimplement;

import mom.mom.interfacerepositoty.IEmployeeRepository;
import mom.mom.interfaceservice.EmployeeServiceInterface;
import mom.mom.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HARRY-PC
 */
@Service
public class EmployeeServiceImplement implements EmployeeServiceInterface{
    
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
    
    
    
}
