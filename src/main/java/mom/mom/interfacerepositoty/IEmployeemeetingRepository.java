/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfacerepositoty;

import mom.mom.model.Employeemeeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bella
 */
@Repository
public interface IEmployeemeetingRepository extends CrudRepository<Employeemeeting, Integer>{
    
}
