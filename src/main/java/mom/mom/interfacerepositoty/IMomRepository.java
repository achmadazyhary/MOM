/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfacerepositoty;

import java.util.List;
import mom.mom.model.Mom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bella
 */
@Repository
public interface IMomRepository extends CrudRepository<Mom, Integer>{
    @Query(value = "SELECT * FROM mom WHERE pic =?1", 
            nativeQuery = true)
    public List<Mom> findByPic(int pic);
//SELECT * FROM mom JOIN meeting WHERE mom.meeting=meeting.id 
}
