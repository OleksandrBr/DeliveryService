package ua.rd.deliveryservice.repository;

import java.util.HashMap;
import java.util.Map;
import ua.rd.deliveryservice.annotation.PostCreate;
import ua.rd.deliveryservice.domain.Pizza;
import ua.rd.deliveryservice.infrastructure.Benchmark;

/**
 *
 * @author andrii
 */
public class InMemPizzaRepository implements PizzaRepository {

    private Map<Integer, Pizza> pizzas;
    @PostCreate
    public void init(){
        System.out.println("Init PizzaInMem");
    }
    
//    public void init() {
//        System.out.println("Init PizzaInMem");
//    }

    public Map<Integer, Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Map<Integer, Pizza> pizzas) {
        this.pizzas = pizzas;
    }    
    
    @Override
    @Benchmark
    public Pizza find(Integer id) {
        return pizzas.get(id);
    }

}
