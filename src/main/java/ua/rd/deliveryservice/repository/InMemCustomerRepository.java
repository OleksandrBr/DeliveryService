/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.rd.deliveryservice.repository;

import java.util.ArrayList;
import java.util.List;
import ua.rd.deliveryservice.domain.Customer;

/**
 *
 * @author obriukhovych
 */
public class InMemCustomerRepository implements CustomerRepository{

    private final List<Customer> customers = new ArrayList<Customer>();
    
    @Override
    public Customer findById(int id) {
        for(Customer customer:customers){
            if(id == customer.getId()){
                return customer;
            }
        }
        return null;
    }
    
    @Override
    public Customer update(Customer customer) {
        for(Customer cust:customers){
            if(customer.getId().equals(cust.getId())){
                customers.remove(cust);
                break;
            }
        }
        customers.add(customer);
        return customer;
    }
    
    public void init(){
       customers.add(new Customer(1,"Alex", 100));
       customers.add(new Customer(2,"Oleks", 200));
    }
    
}
