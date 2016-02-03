package ua.rd.deliveryservice.service;

import ua.rd.deliveryservice.domain.Customer;
import ua.rd.deliveryservice.exception.NoSuchCustomerException;
import ua.rd.deliveryservice.repository.CustomerRepository;

/**
 *
 * @author andrii
 */
public class SimpleCustomerService implements CustomerService {

    private CustomerRepository customerRepository;

    public SimpleCustomerService() {
    }

    public SimpleCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void giveCard(Customer customer) {
        if (customerRepository.findById(customer.getId()) != null) {
            customer.setCard(0);
        } else {
            throw new NoSuchCustomerException();
        }
        customerRepository.update(customer);
    }

    @Override
    public Customer addSumToCard(Customer customer, int sum) {
        customer.addSumToCard(sum);
        return customerRepository.update(customer);
    }

    public Customer createCustomer(int id, String name) {
        return new Customer(id, name);
    }
}
