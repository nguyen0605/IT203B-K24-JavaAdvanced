package btkha1;

import java.sql.*;

public class DoctorLogin {

    public static boolean login(String doctorCode, String password) {
        boolean isAuthenticated = false;

        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String user = "root";
        String passDB = "123456";

        String sql = "SELECT * FROM doctors WHERE doctor_code = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(url, user, passDB);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Gán giá trị vào dấu ?
            ps.setString(1, doctorCode);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isAuthenticated = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isAuthenticated;
    }

    public static void main(String[] args) {
        boolean result = login("BS001", "123456");
        System.out.println(result ? "Đăng nhập thành công" : "Sai thông tin");
    }
}