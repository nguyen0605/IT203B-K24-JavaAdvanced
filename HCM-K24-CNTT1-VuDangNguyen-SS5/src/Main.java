import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductService service = new ProductService();

        while (true) {
            System.out.println("\n========= PRODUCT MANAGEMENT SYSTEM =========");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật số lượng theo ID");
            System.out.println("4. Xóa sản phẩm đã hết hàng");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Price: ");
                        double price = sc.nextDouble();

                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Category: ");
                        String cate = sc.nextLine();

                        service.addProduct(new Product(id, name, price, qty, cate));
                        break;

                    case 2:
                        service.displayProducts();
                        break;

                    case 3:
                        System.out.print("Nhập ID: ");
                        int updateId = sc.nextInt();

                        System.out.print("Số lượng mới: ");
                        int newQty = sc.nextInt();

                        service.updateQuantity(updateId, newQty);
                        break;

                    case 4:
                        service.deleteOutOfStock();
                        System.out.println("Đã xóa sản phẩm hết hàng!");
                        break;

                    case 5:
                        System.out.println("Thoát...");
                        return;

                    default:
                        System.out.println("Chọn sai!");
                }
            } catch (InvalidProductException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }
}