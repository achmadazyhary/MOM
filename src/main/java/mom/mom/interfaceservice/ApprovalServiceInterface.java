/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;

import mom.mom.model.Approval;

/**
 *
 * @author Bella
 */
public interface ApprovalServiceInterface {
    Iterable<Approval> findAll();
    Approval save (Approval approval);
    void delete(Integer id);
}
