package btkha2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PharmacyCatalogue {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_database",
                    "root",
                    "password"
            );

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "SELECT medicine_name, stock FROM Pharmacy"
            );

            /*
             * ================== PHÂN TÍCH ==================
             * - ResultSet có một "con trỏ" (cursor)
             * - Ban đầu con trỏ KHÔNG đứng ở dòng nào (đứng trước dòng đầu tiên)
             *
             * - Mỗi lần gọi rs.next():
             *      + Con trỏ di chuyển xuống dòng tiếp theo
             *      + Trả về true nếu còn dữ liệu
             *      + Trả về false nếu đã hết dữ liệu
             *
             * Nếu dùng:
             *      if (rs.next()) { ... }
             * → Chỉ chạy 1 lần → chỉ lấy được dòng đầu tiên
             *
             * Vì yêu cầu là "in danh sách tất cả thuốc"
             * → Phải dùng vòng lặp while để duyệt toàn bộ ResultSet
             */

            // 3. Duyệt toàn bộ danh sách thuốc
            while (rs.next()) {
                // Mỗi lần lặp: con trỏ đang ở 1 dòng dữ liệu

                String name = rs.getString("medicine_name");
                int stock = rs.getInt("stock");

                System.out.println("Thuốc: " + name + " | Tồn kho: " + stock);
            }

            /*
             * Khi hết dữ liệu:
             * - rs.next() trả về false
             * - vòng while dừng lại
             * → Không lỗi ngay cả khi bảng rỗng
             */

            // 4. Đóng tài nguyên
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}