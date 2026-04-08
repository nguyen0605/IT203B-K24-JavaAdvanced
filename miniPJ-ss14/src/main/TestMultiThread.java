package main;

import dao.OrderDAO;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMultiThread {

    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();

        ExecutorService executor = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 50; i++) {
            executor.submit(() -> {
                orderDAO.placeOrder(1, 1, 1);
            });
        }

        executor.shutdown();
    }
}