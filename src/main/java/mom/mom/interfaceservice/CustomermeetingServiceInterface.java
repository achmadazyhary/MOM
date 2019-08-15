/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;

import mom.mom.model.Customermeeting;

/**
 *
 * @author Bella
 */
public interface CustomermeetingServiceInterface {
    Iterable<Customermeeting> findAll();
    Customermeeting save(Customermeeting customermeeting);
    void delete(Integer id);
}
