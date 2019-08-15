/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceserviceimplement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mom.mom.interfaceservice.ActivationServiceInterface;
import mom.mom.interfacerepositoty.IActivationRepository;
import mom.mom.model.Activation;

/**
 *
 * @author Bella
 */
@Service
public class ActivationServiceImplement implements ActivationServiceInterface{

    @Autowired
    private IActivationRepository activationRepository;
    
    @Override
    public Iterable<Activation> findAll() {
        return activationRepository.findAll();
    }

    @Override
    public Activation save(Activation activation) {
        return activationRepository.save(activation);
    }
    
}
