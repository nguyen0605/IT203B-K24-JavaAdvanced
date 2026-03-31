import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();

        while (true) {
            System.out.println("\n----- QUẢN LÝ SẢN PHẨM -----");
            System.out.println("1. Thêm");
            System.out.println("2. Xem");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine(); // fix lỗi trôi

            switch (choice) {

                case 1: // CREATE
                    System.out.print("Loại (1-Physical, 2-Digital): ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Extra (weight/size): ");
                    double extra = sc.nextDouble();

                    Product p = ProductFactory.createProduct(type, id, name, price, extra);
                    if (p != null) {
                        db.add(p);
                        System.out.println("Thêm thành công");
                    }
                    break;

                case 2: // READ
                    for (Product prod : db.getAll()) {
                        prod.displayInfo(); // polymorphism
                    }
                    break;

                case 3: // UPDATE
                    System.out.print("Nhập ID cần sửa: ");
                    String updateId = sc.nextLine();

                    Product found = db.findById(updateId);
                    if (found == null) {
                        System.out.println("Không tìm thấy");
                        break;
                    }

                    System.out.print("Name mới: ");
                    String newName = sc.nextLine();

                    System.out.print("Price mới: ");
                    double newPrice = sc.nextDouble();

                    found.name = newName;
                    found.price = newPrice;

                    if (found instanceof PhysicalProduct) {
                        System.out.print("Weight mới: ");
                        double w = sc.nextDouble();
                        ((PhysicalProduct) found).setWeight(w);
                    } else if (found instanceof DigitalProduct) {
                        System.out.print("Size mới: ");
                        double s = sc.nextDouble();
                        ((DigitalProduct) found).setSize(s);
                    }

                    System.out.println("Cập nhật xong");
                    break;

                case 4: // DELETE
                    System.out.print("Nhập ID cần xóa: ");
                    String deleteId = sc.nextLine();

                    db.delete(deleteId);
                    System.out.println("Đã xóa (nếu tồn tại)");
                    break;

                case 5:
                    System.out.println("Thoát...");
                    return;
            }
        }
    }
}