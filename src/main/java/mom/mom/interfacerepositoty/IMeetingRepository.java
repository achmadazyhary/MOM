/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfacerepositoty;

import java.util.List;
import mom.mom.model.Meeting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bella
 */
@Repository
public interface IMeetingRepository extends CrudRepository<Meeting, Integer>{
    @Query(value = "SELECT * FROM meeting WHERE manager =?1", 
            nativeQuery = true)
     public List<Meeting> findByManager(int manager);
    @Query(value = "SELECT * FROM meeting WHERE pic =?1", 
            nativeQuery = true)
    public List<Meeting> findByPic(int pic);
}
