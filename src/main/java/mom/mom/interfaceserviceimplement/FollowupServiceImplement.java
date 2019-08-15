/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceserviceimplement;

import mom.mom.interfacerepositoty.IFollowupRepository;
import mom.mom.interfaceservice.FollowupServiceInterface;
import mom.mom.model.Followup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bella
 */
@Service
public class FollowupServiceImplement implements FollowupServiceInterface{

    @Autowired
    private IFollowupRepository followupRepository;
    
    @Override
    public Iterable<Followup> findAll() {
        return followupRepository.findAll();
    }

    @Override
    public Followup save(Followup followup) {
        return followupRepository.save(followup);
    }

    @Override
    public void delete(Integer id) {
        followupRepository.deleteById(id);
    }
    
}
