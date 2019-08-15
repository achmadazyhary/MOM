/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfacerepositoty;

import java.util.List;
import mom.mom.model.Approval;
import mom.mom.model.Mom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bella
 */
@Repository
public interface IApprovalRepository extends CrudRepository<Approval, Integer>{
        @Query(value = "SELECT * FROM mom WHERE manager =?1", 
            nativeQuery = true)
    public List<Mom> findByManager(int manager);

}
