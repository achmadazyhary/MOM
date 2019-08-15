/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceserviceimplement;

import mom.mom.interfacerepositoty.IApprovalRepository;
import mom.mom.interfaceservice.ApprovalServiceInterface;
import mom.mom.model.Approval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bella
 */
@Service
public class ApprovalServiceImplement implements ApprovalServiceInterface{

    @Autowired
    private IApprovalRepository approvalRepository;
    
  

    @Override
    public Approval save(Approval approval) {
        return approvalRepository.save(approval);
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Approval> findAll() {
        return approvalRepository.findAll();
    }
    
}
