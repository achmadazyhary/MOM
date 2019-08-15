/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;
import java.util.List;
import java.util.Optional;
import mom.mom.model.Mom;

/**
 *
 * @author Bella
 */
public interface MomServiceInterface {
    Iterable<Mom> findAll();
    Mom save (Mom mom);
    void delete(Integer id);
    List<Mom> findByPic(int pic);
    Optional<Mom> findById(int id);
}
