/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;

import mom.mom.model.Employee;

/**
 *
 * @author HARRY-PC
 */
public interface EmployeeServiceInterface {
    Iterable<Employee> findAll();
    Employee save(Employee employee);
    void delete(Integer id);
    Employee findByEmail(String email);
}
