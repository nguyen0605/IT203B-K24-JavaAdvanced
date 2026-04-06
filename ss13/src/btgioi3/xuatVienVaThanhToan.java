import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {
    Connection conn = null;

    try {
        DatabaseMetaData DatabaseManager = null;
        conn = DatabaseManager.getConnection();
        conn.setAutoCommit(false); // 🔥 Bắt đầu transaction

        // =========================
        // 🔎 BƯỚC 1: Lấy số dư
        // =========================
        String sqlCheckBalance = "SELECT balance FROM Patient_Wallet WHERE patient_id = ?";
        PreparedStatement psCheck = conn.prepareStatement(sqlCheckBalance);
        psCheck.setInt(1, maBenhNhan);

        ResultSet rs = psCheck.executeQuery();

        if (!rs.next()) {
            throw new Exception("Không tìm thấy bệnh nhân!");
        }

        double balance = rs.getDouble("balance");

        // =========================
        // 🚨 BẪY 1: Không đủ tiền
        // =========================
        if (balance < tienVienPhi) {
            throw new Exception("Số dư không đủ để thanh toán!");
        }

        // =========================
        // 💸 BƯỚC 2: Trừ tiền
        // =========================
        String sqlUpdateWallet =
                "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
        PreparedStatement ps1 = conn.prepareStatement(sqlUpdateWallet);
        ps1.setDouble(1, tienVienPhi);
        ps1.setInt(2, maBenhNhan);

        int row1 = ps1.executeUpdate();

        // =========================
        // 🚨 BẪY 2: Row affected = 0
        // =========================
        if (row1 == 0) {
            throw new Exception("Trừ tiền thất bại!");
        }

        // =========================
        // 🛏️ BƯỚC 3: Giải phóng giường
        // =========================
        String sqlUpdateBed =
                "UPDATE Bed SET status = 'TRONG' WHERE patient_id = ?";
        PreparedStatement ps2 = conn.prepareStatement(sqlUpdateBed);
        ps2.setInt(1, maBenhNhan);

        int row2 = ps2.executeUpdate();

        // 🚨 Bẫy 2
        if (row2 == 0) {
            throw new Exception("Giải phóng giường thất bại!");
        }

        // =========================
        // 🧾 BƯỚC 4: Cập nhật bệnh nhân
        // =========================
        String sqlUpdatePatient =
                "UPDATE Patient SET status = 'DA_XUAT_VIEN' WHERE patient_id = ?";
        PreparedStatement ps3 = conn.prepareStatement(sqlUpdatePatient);
        ps3.setInt(1, maBenhNhan);

        int row3 = ps3.executeUpdate();

        // 🚨 Bẫy 2
        if (row3 == 0) {
            throw new Exception("Cập nhật trạng thái bệnh nhân thất bại!");
        }

        // =========================
        // ✅ COMMIT
        // =========================
        conn.commit();
        System.out.println("Xuất viện thành công!");

    } catch (Exception e) {
        System.out.println("Lỗi: " + e.getMessage());

        try {
            if (conn != null) {
                // ❌ ROLLBACK toàn bộ
                conn.rollback();
            }
        } catch (Exception rollbackEx) {
            rollbackEx.printStackTrace();
        }

    } finally {
        try {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

void main() {
}
