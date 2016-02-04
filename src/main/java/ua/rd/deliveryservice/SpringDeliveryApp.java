package ua.rd.deliveryservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.rd.deliveryservice.domain.Customer;
import ua.rd.deliveryservice.domain.Order;
import ua.rd.deliveryservice.domain.Pizza;
import ua.rd.deliveryservice.listeners.OrderServiceListner;
import ua.rd.deliveryservice.repository.PizzaRepository;
import ua.rd.deliveryservice.service.OrderService;

/**
 *
 * @author andrii
 */
public class SpringDeliveryApp {

    public static void main(String[] args) {
//        int pizzaId = 2;
//        ConfigurableApplicationContext repositoryContext
//                = new ClassPathXmlApplicationContext("repositoryContext.xml");
//
//        ConfigurableApplicationContext appContext
//                = new ClassPathXmlApplicationContext(
//                        new String[]{"appContext.xml"}, repositoryContext);
//
//        ApplicationContext parent = appContext.getParent();
//        System.out.println(parent);
//
//        Pizza pizza = (Pizza) appContext.getBean("pizzaFactoryBean");
//        System.out.println(pizza);
//
//        Customer c = appContext.getBean("customer", Customer.class);
//        System.out.println(c);
//
//        Customer nc = appContext.getBean("newCustomer", Customer.class);
////        System.out.println(nc);
//        System.out.println(appContext.getBean("newCustomer", Customer.class));
//
//        PizzaRepository pizzaRepository = (PizzaRepository) appContext.getBean("pizzaRepo");
//        System.out.println(pizzaRepository.find(pizzaId));
//
//        OrderService orderService = (OrderService) appContext.getBean("orderService");
//        Order order = orderService.placeNewOrder(c, pizzaId);
//        System.out.println(order);
//
//        repositoryContext.close();
//        appContext.close();

        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext.xml");
        applicationContext.addApplicationListener(new OrderServiceListner());
        OrderService orderService = applicationContext.getBean("simpleOrderService", OrderService.class);
        Order order = orderService.placeNewOrder(new Customer(1, "123", 100), 1, 1, 1, 1, 1);

    }
}
