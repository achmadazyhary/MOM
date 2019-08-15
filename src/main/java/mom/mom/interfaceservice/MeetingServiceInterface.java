/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;

import java.util.List;
import mom.mom.model.Meeting;

/**
 *
 * @author Bella
 */
public interface MeetingServiceInterface {
    Iterable<Meeting> findAll();
    Meeting save (Meeting meeting);
    void delete (Integer id);
    List<Meeting> findByManager(int manager);
    List<Meeting> findByPic(int pic);
}
