package btkha1;

import java.util.*;

class Order {
    private String orderId;
    private Customer customer;
    private Map<Product, Integer> items = new HashMap<>();
    private double total;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public void addProduct(Product product, int quantity) {
        items.put(product, quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }
}