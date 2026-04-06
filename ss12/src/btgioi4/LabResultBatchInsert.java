package btgioi4;

import java.sql.*;
import java.util.List;

public class LabResultBatchInsert {

    public static <LabResult> void insertResults(List<LabResult> results) {

        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String user = "root";
        String password = "123456";

        String sql = "INSERT INTO lab_results(patient_id, test_type, value) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Khởi tạo 1 lần duy nhất

            for (LabResult r : results) {

                // Gán tham số mỗi vòng lặp
                ps.setInt(1, r.getPatientId());
                ps.setString(2, r.getTestType());
                ps.setDouble(3, r.getValue());

                ps.executeUpdate(); // thực thi
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}