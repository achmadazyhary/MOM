/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfacerepositoty;

import mom.mom.model.Customer;
import mom.mom.model.Customermeeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bella
 */
@Repository
public interface ICustomermeetingRepository extends CrudRepository<Customermeeting, Integer>{
    
}
