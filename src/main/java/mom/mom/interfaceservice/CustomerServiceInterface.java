/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;

import java.util.Optional;
import mom.mom.model.Customer;

/**
 *
 * @author HARRY-PC
 */
public interface CustomerServiceInterface {
    Iterable<Customer> findAll();
    Customer save(Customer customer);
    void delete(Integer id);
    Optional<Customer> findById(Integer id);
}
