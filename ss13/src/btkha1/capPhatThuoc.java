import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;

public void capPhatThuoc(int medicineId, int patientId) {
    Connection conn = null;
    try {
        DatabaseMetaData DatabaseManager = null;
        conn = DatabaseManager.getConnection();

        // 🔥 Tắt auto-commit
        conn.setAutoCommit(false);

        // Thao tác 1: Trừ thuốc
        String sqlUpdateInventory =
                "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE medicine_id = ?";
        PreparedStatement ps1 = conn.prepareStatement(sqlUpdateInventory);
        ps1.setInt(1, medicineId);
        ps1.executeUpdate();

        // ❗ Giả lập lỗi
        int x = 10 / 0;

        // Thao tác 2: Lưu lịch sử
        String sqlInsertHistory =
                "INSERT INTO Prescription_History (patient_id, medicine_id, date) VALUES (?, ?, GETDATE())";
        PreparedStatement ps2 = conn.prepareStatement(sqlInsertHistory);
        ps2.setInt(1, patientId);
        ps2.setInt(2, medicineId);
        ps2.executeUpdate();

        // ✅ Nếu tất cả OK → commit
        conn.commit();

        System.out.println("Cấp phát thuốc thành công!");

    } catch (Exception e) {
        System.out.println("Có lỗi xảy ra: " + e.getMessage());

        try {
            if (conn != null) {
                // ❌ Có lỗi → rollback toàn bộ
                conn.rollback();
            }
        } catch (Exception rollbackEx) {
            rollbackEx.printStackTrace();
        }

    } finally {
        try {
            if (conn != null) {
                conn.setAutoCommit(true); // reset lại
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

void main() {
}
