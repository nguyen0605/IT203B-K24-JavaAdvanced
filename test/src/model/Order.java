package model;

import java.time.LocalDate;
import java.util.Scanner;

public class Order {
    private String orderId;
    private String customerName;
    private double totalAmount;
    private String status;
    private LocalDate orderDate;

    public Order() {}

    public Order(String orderId, String customerName, double totalAmount, String status, LocalDate orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.status = status;
        this.orderDate = orderDate;
    }

    public void inputData(Scanner sc) {
        while (true) {
            System.out.print("Nhập orderId (ODxxx): ");
            orderId = sc.nextLine();
            if (orderId.matches("OD\\d{3}")) break;
            System.out.println("Sai định dạng!");
        }

        do {
            System.out.print("Tên khách: ");
            customerName = sc.nextLine();
        } while (customerName.trim().isEmpty());

        do {
            System.out.print("Tổng tiền: ");
            totalAmount = Double.parseDouble(sc.nextLine());
        } while (totalAmount <= 0);

        do {
            System.out.print("Trạng thái (Pending/Completed/Cancelled): ");
            status = sc.nextLine();
        } while (!status.matches("Pending|Completed|Cancelled"));

        do {
            System.out.print("Ngày (yyyy-mm-dd): ");
            orderDate = LocalDate.parse(sc.nextLine());
        } while (orderDate.isAfter(LocalDate.now()));
    }

    public void displayData() {
        System.out.printf("%s | %s | %.2f | %s | %s\n",
                orderId, customerName, totalAmount, status, orderDate);
    }

    // Getter Setter đầy đủ
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalAmount() { return totalAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}