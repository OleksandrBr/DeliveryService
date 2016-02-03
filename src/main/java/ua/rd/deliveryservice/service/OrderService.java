package ua.rd.deliveryservice.service;

import ua.rd.deliveryservice.domain.Customer;
import ua.rd.deliveryservice.domain.Order;

/**
 *
 * @author andrii
 */
public interface OrderService {

    Order placeNewOrder(Customer customer, int... pizzaID);

    void saveOrder(Order order);
    
    Order addPizzasToOrder(int orderId, int... pizzaID);
    
    void payForOrder(Order order);
}
