import business.OrderBusiness;
import factory.OrderFactory;
import model.Order;
import strategy.FastShipping;
import strategy.NormalShipping;
import strategy.SavingShipping;
import strategy.ShippingStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderBusiness ob = OrderBusiness.getInstance();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm đơn");
            System.out.println("2. Hiển thị");
            System.out.println("3. Tìm theo tiền");
            System.out.println("4. Tìm theo tên");
            System.out.println("5. Cập nhật trạng thái");
            System.out.println("6. Xóa Cancelled");
            System.out.println("7. Sắp xếp giảm dần");
            System.out.println("8. Thống kê");
            System.out.println("9. Tính phí ship");
            System.out.println("0. Thoát");

            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Loại (online/store): ");
                    String type = sc.nextLine();
                    Order o = OrderFactory.createOrder(type);
                    o.inputData(sc);
                    ob.addOrder(o);
                    break;

                case 2:
                    ob.displayAll();
                    break;

                case 3:
                    System.out.print("Nhập X: ");
                    ob.findByAmount(Double.parseDouble(sc.nextLine()));
                    break;

                case 4:
                    System.out.print("Tên: ");
                    ob.findByName(sc.nextLine());
                    break;

                case 5:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Status: ");
                    ob.updateStatus(id, sc.nextLine());
                    break;

                case 6:
                    ob.deleteCancelled();
                    break;

                case 7:
                    ob.sortDesc();
                    break;

                case 8:
                    ob.statistics();
                    break;

                case 9:
                    System.out.print("Số tiền: ");
                    double amount = Double.parseDouble(sc.nextLine());

                    System.out.print("Loại ship (fast/normal/saving): ");
                    String s = sc.nextLine();

                    ShippingStrategy strategy;
                    switch (s) {
                        case "fast": strategy = new FastShipping(); break;
                        case "normal": strategy = new NormalShipping(); break;
                        default: strategy = new SavingShipping();
                    }

                    System.out.println("Phí ship: " + strategy.calculate(amount));
                    break;

                case 0:
                    return;
            }
        }
    }
}