/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.rd.deliveryservice.repository;

import ua.rd.deliveryservice.domain.Customer;

/**
 *
 * @author obriukhovych
 */
public interface CustomerRepository {
    Customer update(Customer customer);
    Customer findById(int id);
}
