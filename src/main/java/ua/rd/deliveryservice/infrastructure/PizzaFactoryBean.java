/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.rd.deliveryservice.infrastructure;

import org.springframework.beans.factory.FactoryBean;
import ua.rd.deliveryservice.domain.Pizza;


/**
 *
 * @author obriukhovych
 */
public class PizzaFactoryBean implements FactoryBean<Pizza> {
    private Integer id;
    private String name;
    private Pizza.PizzaType type;
    private Integer price;

    
    @Override
    public Pizza getObject() throws Exception {
        return new Pizza(id, name, type, price);

}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Pizza.PizzaType type) {
        this.type = type;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

@Override
        public Class

<?> getObjectType() {
        return Pizza.class;
}

    @Override
        public boolean isSingleton() {
        return true;
    }

}
