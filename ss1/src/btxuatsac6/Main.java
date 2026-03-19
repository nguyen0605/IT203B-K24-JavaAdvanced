package btxuatsac6;

import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();

        try {
            System.out.print("Nhập tên: ");
            String name = sc.nextLine();
            user.setName(name);

            System.out.print("Nhập năm sinh: ");
            int year = Integer.parseInt(sc.nextLine());

            int age = 2026 - year;
            user.setAge(age);

            user.printInfo();

            // Gọi xử lý file (Checked Exception)
            UserService.saveToFile(user);

        } catch (NumberFormatException e) {
            Logger.logError("Sai định dạng số: " + e.getMessage());

        } catch (InvalidAgeException e) {
            Logger.logError("Lỗi nghiệp vụ: " + e.getMessage());

        } catch (IOException e) {
            Logger.logError("Lỗi hệ thống (file): " + e.getMessage());

        } finally {
            sc.close();
            System.out.println("Đã đóng tài nguyên.");
        }

        System.out.println("Chương trình kết thúc an toàn.");
    }
}
