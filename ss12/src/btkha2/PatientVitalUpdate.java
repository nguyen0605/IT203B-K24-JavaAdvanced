package btkha2;

import java.sql.*;

public class PatientVitalUpdate {

    public static void updateVitals(int patientId, double temperature, int heartRate) {

        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String user = "root";
        String password = "123456";

        String sql = "UPDATE patients SET temperature = ?, heart_rate = ? WHERE patient_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Gán giá trị đúng kiểu dữ liệu
            ps.setDouble(1, temperature); // nhiệt độ (double)
            ps.setInt(2, heartRate);      // nhịp tim (int)
            ps.setInt(3, patientId);      // mã bệnh nhân

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Cập nhật thành công!");
            } else {
                System.out.println("Không tìm thấy bệnh nhân!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        updateVitals(1, 37.5, 80);
    }
}