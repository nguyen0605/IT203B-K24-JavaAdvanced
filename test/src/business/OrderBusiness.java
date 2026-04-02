package business;

import model.Order;

import java.util.*;
import java.util.stream.Collectors;

public class OrderBusiness {
    private static OrderBusiness instance;
    private List<Order> orders = new ArrayList<>();

    private OrderBusiness() {}

    public static OrderBusiness getInstance() {
        if (instance == null) {
            instance = new OrderBusiness();
        }
        return instance;
    }

    public void addOrder(Order o) {
        boolean exists = orders.stream()
                .anyMatch(x -> x.getOrderId().equals(o.getOrderId()));

        if (exists) {
            System.out.println("Trùng ID!");
        } else {
            orders.add(o);
        }
    }

    public void displayAll() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        orders.forEach(Order::displayData);
    }

    public void findByAmount(double x) {
        orders.stream()
                .filter(o -> o.getTotalAmount() > x)
                .forEach(Order::displayData);
    }

    public void findByName(String name) {
        orders.stream()
                .filter(o -> o.getCustomerName().toLowerCase().contains(name.toLowerCase()))
                .forEach(Order::displayData);
    }

    public void updateStatus(String id, String status) {
        Optional<Order> o = orders.stream()
                .filter(x -> x.getOrderId().equals(id))
                .findFirst();

        if (o.isPresent()) {
            o.get().setStatus(status);
        } else {
            System.out.println("Không tìm thấy!");
        }
    }

    public void deleteCancelled() {
        orders.removeIf(o -> o.getStatus().equals("Cancelled"));
    }

    public void sortDesc() {
        orders.sort((a, b) -> Double.compare(b.getTotalAmount(), a.getTotalAmount()));
    }

    public void statistics() {
        Map<String, Long> map = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()));

        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}