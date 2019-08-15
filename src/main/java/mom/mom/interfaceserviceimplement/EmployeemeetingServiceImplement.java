/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceserviceimplement;

import mom.mom.interfacerepositoty.IEmployeemeetingRepository;
import mom.mom.interfaceservice.EmployeemeetingServiceInterface;
import mom.mom.model.Employeemeeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bella
 */
@Service
public class EmployeemeetingServiceImplement implements EmployeemeetingServiceInterface{

    @Autowired
    private IEmployeemeetingRepository employeemeetingRepository;
    
    @Override
    public Iterable<Employeemeeting> findAll() {
        return employeemeetingRepository.findAll();
    }

    @Override
    public Employeemeeting save(Employeemeeting employeemeeting) {
        return employeemeetingRepository.save(employeemeeting);
    }

    @Override
    public void delete(Integer id) {
        employeemeetingRepository.deleteById(id);
    }
    
}
