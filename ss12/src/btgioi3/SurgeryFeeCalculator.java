package btgioi3;

import java.sql.*;

public class SurgeryFeeCalculator {

    public static void getSurgeryFee(int surgeryId) {

        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String user = "root";
        String password = "123456";

        String sql = "{CALL GET_SURGERY_FEE(?, ?)}";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             CallableStatement cs = conn.prepareCall(sql)) {

            // 1. Set tham số IN
            cs.setInt(1, surgeryId);

            // 2. Đăng ký tham số OUT (DECIMAL)
            cs.registerOutParameter(2, Types.DECIMAL);

            // 3. Thực thi
            cs.execute();

            // 4. Lấy kết quả
            double totalCost = cs.getDouble(2);

            System.out.println("Chi phí phẫu thuật: " + totalCost);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getSurgeryFee(101);
    }
}