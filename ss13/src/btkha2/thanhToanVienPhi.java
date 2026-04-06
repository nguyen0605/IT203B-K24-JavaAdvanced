import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public void thanhToanVienPhi(int patientId, int invoiceId, double amount) {
    Connection conn = null;
    try {
        DatabaseMetaData DatabaseManager = null;
        conn = DatabaseManager.getConnection();

        conn.setAutoCommit(false);

        // Trừ tiền ví
        String sqlDeductWallet =
                "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
        PreparedStatement ps1 = conn.prepareStatement(sqlDeductWallet);
        ps1.setDouble(1, amount);
        ps1.setInt(2, patientId);
        ps1.executeUpdate();

        // Lỗi SQL (cố tình)
        String sqlUpdateInvoice =
                "UPDATE Invoicess SET status = 'PAID' WHERE invoice_id = ?";
        PreparedStatement ps2 = conn.prepareStatement(sqlUpdateInvoice);
        ps2.setInt(1, invoiceId);
        ps2.executeUpdate();

        conn.commit();
        System.out.println("Thanh toán hoàn tất!");

    } catch (SQLException e) {
        System.out.println("Lỗi hệ thống: Không thể hoàn tất thanh toán. Chi tiết: " + e.getMessage());

        try {
            if (conn != null) {
                // 🔥 QUAN TRỌNG: rollback khi có lỗi
                conn.rollback();
            }
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }

    } finally {
        try {
            if (conn != null) {
                conn.setAutoCommit(true); // reset lại trạng thái
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

void main() {
}
