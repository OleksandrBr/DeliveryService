/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.rd.deliveryservice.listeners;

import org.springframework.context.ApplicationListener;

/**
 *
 * @author obriukhovych
 */
public class OrderServiceListner implements ApplicationListener<OrderCreatedEvent>{

    @Override
    public void onApplicationEvent(OrderCreatedEvent orderCreatedEvent) {
        System.out.println(orderCreatedEvent.getOrder() + " created!");
    }
}
