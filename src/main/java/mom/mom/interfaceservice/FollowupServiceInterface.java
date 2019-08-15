/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;

import mom.mom.model.Followup;

/**
 *
 * @author Bella
 */
public interface FollowupServiceInterface {
    Iterable<Followup> findAll();
    Followup save (Followup followup);
    void delete(Integer id);
}
