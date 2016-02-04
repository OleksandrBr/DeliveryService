/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import org.springframework.context.ApplicationEvent;
import ua.rd.deliveryservice.domain.Order;



/**
 *
 * @author obriukhovych
 */
public class OrderCreatedEvent extends ApplicationEvent {

    private Order order;

    public OrderCreatedEvent(Object source, Order order) {
        super(source);
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}