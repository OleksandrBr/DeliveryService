package ua.rd.deliveryservice.service;

import ua.rd.deliveryservice.domain.Pizza;
import ua.rd.deliveryservice.domain.Order;
import ua.rd.deliveryservice.domain.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import ua.rd.deliveryservice.exception.NoSuchOrderException;
import ua.rd.deliveryservice.infrastructure.Benchmark;
import ua.rd.deliveryservice.repository.OrderRepository;

/**
 *
 * @author andrii
 */
public class SimpleOrderService implements OrderService {

    private static int orderCount = 0;

    private OrderRepository orderRepository;
    private PizzaService pizzaService;
    private CustomerService customerService;
    
    private Order order;

    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.customerService = customerService;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    //@BanchMark
    public Order placeNewOrder(Customer customer, int... pizzaID) {
        orderCount++;
        List<Pizza> pizzas = new ArrayList<Pizza>();

        for (Integer id : pizzaID) {
            pizzas.add(getPizzaById(id));
        }

        Order newOrder = new Order(orderCount, pizzas, customer, Order.Status.NEW);
        saveOrder(newOrder);
        return newOrder;
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order addPizzasToOrder(int orderId, int... pizzaID) {
        Order order = orderRepository.findById(orderId);
        if (order == null) {
            throw new NoSuchOrderException();
        }

        List<Pizza> pizzas = new ArrayList<Pizza>();
        for (Integer id : pizzaID) {
            pizzas.add(getPizzaById(id));
        }
        
        order.addMorePizzaz(pizzas);
        order.setStatus(Order.Status.IN_PROGRSS);
        return orderRepository.update(order);
    }
    
    @Override
    public void payForOrder(Order order){
        order.setStatus(Order.Status.DONE);
        orderRepository.update(order);
        if(order.getCustomer().getCard()!=null){
            customerService.addSumToCard(order.getCustomer(), order.getCost());
        }     
    }

    private Pizza getPizzaById(Integer id) {
        return pizzaService.find(id);
    }

    public void init() {
    }
}