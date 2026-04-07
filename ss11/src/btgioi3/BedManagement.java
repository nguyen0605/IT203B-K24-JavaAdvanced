package btgioi3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BedManagement {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_database",
                    "root",
                    "password"
            );

            Statement stmt = conn.createStatement();
            Scanner sc = new Scanner(System.in);

            // Nhập mã giường cần cập nhật
            System.out.print("Nhập mã giường: ");
            String inputId = sc.nextLine();

            String sql = "UPDATE Beds SET bed_status = 'Occupied' WHERE bed_id = '" + inputId + "'";

            /*
             * ================== PHÂN TÍCH ==================
             * - executeUpdate(sql) KHÔNG trả về dữ liệu như SELECT
             * - Nó trả về 1 số nguyên (int)
             *
             * Ý nghĩa:
             *      + 0  → KHÔNG có dòng nào bị ảnh hưởng
             *            → tức là bed_id không tồn tại
             *
             *      + >0 → số dòng đã được cập nhật thành công
             *
             * Code cũ:
             *      stmt.executeUpdate(sql);
             *      → không kiểm tra kết quả
             *      → luôn in "thành công" → gây hiểu lầm
             *
             * Cách đúng:
             *      → Lưu kết quả trả về vào biến
             *      → Kiểm tra giá trị này để phản hồi chính xác
             */

            int rowsAffected = stmt.executeUpdate(sql);

            // 2. Kiểm tra kết quả cập nhật
            if (rowsAffected > 0) {
                System.out.println("Cập nhật giường bệnh thành công!");
            } else {
                System.out.println("LỖI: Mã giường không tồn tại!");
            }

            // 3. Đóng tài nguyên
            stmt.close();
            conn.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
