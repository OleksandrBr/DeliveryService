package ua.rd.deliveryservice.repository;

import java.util.ArrayList;
import java.util.List;
import ua.rd.deliveryservice.domain.Order;

/**
 *
 * @author andrii
 */
public class InMemOrderRepository implements OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    @Override
    public Order save(Order order) {
        orders.add(order);
        return order;
    }
    
    @Override
    public Order findById(int id) {
        for(Order order:orders){
            if(id == order.getId()){
                return order;
            }
        }
        return null;
    }

    @Override
    public Order update(Order order) {
        for(Order ord:orders){
            if(order.getId().equals(ord.getId())){
                orders.remove(ord);
                break;
            }
        }
        orders.add(order);
        return order;
    }

}
