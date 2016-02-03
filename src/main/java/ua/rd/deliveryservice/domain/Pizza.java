package ua.rd.deliveryservice.domain;

/**
 *
 * @author andrii
 */
public class Pizza {

    private Integer id;
    private String name;
    private PizzaType pizzaType;
    private Integer price;


    public enum PizzaType {
        VEGETERIAN, SEA, MEAT
    }

    public Pizza() {
    }

    public Pizza(Integer id, String name, PizzaType pizzaType, Integer price) {
        this.id = id;
        this.name = name;
        this.pizzaType = pizzaType;
        this.price = price;
    }

//    public Pizza(Integer id, String name, String pizzaType) {
//        this.id = id;
//        this.name = name;
//        this.pizzaType = PizzaType.valueOf(pizzaType);
//    }
   
    

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    
   
    @Override
    public String toString() {
        return "Pizza{" + "id=" + id + ", name=" + name + ", pizzaType=" + pizzaType + ", price=" + price + '}';
    }
    
    
}