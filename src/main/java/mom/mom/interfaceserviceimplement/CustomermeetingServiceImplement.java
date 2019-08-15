/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceserviceimplement;

import mom.mom.interfacerepositoty.ICustomerRepository;
import mom.mom.interfacerepositoty.ICustomermeetingRepository;
import mom.mom.interfaceservice.CustomermeetingServiceInterface;
import mom.mom.model.Customermeeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bella
 */
@Service
public class CustomermeetingServiceImplement implements CustomermeetingServiceInterface{

    @Autowired
    private ICustomermeetingRepository customermeetingRepository;
    
    @Override
    public Iterable<Customermeeting> findAll() {
        return customermeetingRepository.findAll();
    }

    @Override
    public Customermeeting save(Customermeeting customermeeting) {
        return customermeetingRepository.save(customermeeting);
    }

    @Override
    public void delete(Integer id) {
        customermeetingRepository.deleteById(id);
    }
    
}
