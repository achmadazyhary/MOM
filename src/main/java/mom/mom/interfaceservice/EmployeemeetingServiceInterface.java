/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;

import mom.mom.model.Employeemeeting;

/**
 *
 * @author Bella
 */
public interface EmployeemeetingServiceInterface {
    Iterable<Employeemeeting> findAll();
    Employeemeeting save (Employeemeeting employeemeeting);
    void delete (Integer id);
}
