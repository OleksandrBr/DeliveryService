/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.rd.deliveryservice.service;

import ua.rd.deliveryservice.domain.Customer;

/**
 *
 * @author obriukhovych
 */
public interface CustomerService {
    void giveCard(Customer customer);
    Customer addSumToCard(Customer customer, int sum);
    Customer createCustomer(int id, String name, Integer card);
}
