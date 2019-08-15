/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceserviceimplement;

import java.util.List;
import mom.mom.interfacerepositoty.IMeetingRepository;
import mom.mom.interfaceservice.MeetingServiceInterface;
import mom.mom.model.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bella
 */
@Service
public class MeetingServiceImplement implements MeetingServiceInterface{

    @Autowired
    public IMeetingRepository meetingRepository;
    
    @Override
    public Iterable<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting save(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public void delete(Integer id) {
        meetingRepository.deleteById(id);
    }

    @Override
    public List<Meeting> findByManager(int manager) {
        return meetingRepository.findByManager(manager);
    }

    @Override
    public List<Meeting> findByPic(int pic) {
        return meetingRepository.findByPic(pic);
    }
    
}
