/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceserviceimplement;

import java.util.List;
import java.util.Optional;
import mom.mom.interfacerepositoty.IMomRepository;
import mom.mom.interfaceservice.MomServiceInterface;
import mom.mom.model.Mom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bella
 */
@Service
public class MomServiceImplement implements MomServiceInterface{

    @Autowired
    private IMomRepository momRepository;
    
    @Override
    public Iterable<Mom> findAll() {
        return momRepository.findAll();
    }

    @Override
    public Mom save(Mom mom) {
        return momRepository.save(mom);
    }

    @Override
    public void delete(Integer id) {
        momRepository.deleteById(id);
    }

    @Override
    public List<Mom> findByPic(int pic) {
       return momRepository.findByPic(pic);
    }

    @Override
    public Optional<Mom> findById(int id) {
        return momRepository.findById(id);
    }



    
}
