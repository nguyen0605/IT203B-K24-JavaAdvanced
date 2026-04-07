package btgioi4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PatientSearch {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_database",
                    "root",
                    "password"
            );

            Statement stmt = conn.createStatement();
            Scanner sc = new Scanner(System.in);

            // Nhập tên bệnh nhân
            System.out.print("Nhập tên bệnh nhân: ");
            String patientName = sc.nextLine();

            /*
             * ================== PHÂN TÍCH SQL INJECTION ==================
             *
             * Nếu hacker nhập:
             *      ' OR '1'='1
             *
             * Câu SQL sẽ trở thành:
             *      SELECT * FROM Patients WHERE full_name = '' OR '1'='1'
             *
             * Phân tích:
             *      - full_name = ''  → thường là false
             *      - '1'='1'         → LUÔN TRUE
             *
             * Toán tử OR:
             *      false OR true → TRUE
             *
             * ⇒ Kết quả: WHERE luôn đúng → trả về TOÀN BỘ dữ liệu
             *
             * Đây là SQL Injection → rò rỉ dữ liệu cực kỳ nguy hiểm
             */

            // 2. LỌC dữ liệu đầu vào (theo yêu cầu đề bài)
            patientName = sanitizeInput(patientName);

            String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";

            ResultSet rs = stmt.executeQuery(sql);

            // 3. In kết quả
            while (rs.next()) {
                System.out.println("Tên: " + rs.getString("full_name"));
            }

            // 4. Đóng tài nguyên
            rs.close();
            stmt.close();
            conn.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * ================== GIẢI PHÁP (THEO ĐỀ BÀI) ==================
     *
     * - Loại bỏ các ký tự nguy hiểm:
     *      '   → phá vỡ chuỗi SQL
     *      --  → comment SQL
     *      ;   → kết thúc câu lệnh
     *
     */
    public static String sanitizeInput(String input) {
        if (input == null) return "";

        return input
                .replace("'", "")
                .replace("--", "")
                .replace(";", "");
    }
}
