package ua.rd.deliveryservice.domain;

/**
 *
 * @author andrii
 */
public class Customer {
    
    private Integer id;
    private String name;
    private Address address;
    private Integer card;
    
    public Customer() {
    }

    public Customer(Integer id, String name, Integer card) {
        this.id = id;
        this.name = name;
        this.card = card;
    }

    public Customer(String name) {
        this.name = name;
    }
    
    public void addSumToCard(int sum){
        if(card != null){
            card = card + sum;
        }  
    }

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", address=" + address + ", card=" + card + '}';
    }    
}