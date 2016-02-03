package ua.rd.deliveryservice.repository;

import ua.rd.deliveryservice.domain.Order;

/**
 *
 * @author andrii
 */
public interface OrderRepository {
    Order save(Order order);
    Order findById(int id);
    Order update(Order order);
}
