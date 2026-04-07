import java.sql.*;

public class TransferMoney {

    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASS = "0605";

    public static void main(String[] args) {

        String senderId = "ACC01";
        String receiverId = "ACC02";
        double amount = 1000;

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASS)
        ) {

            // 🔥 Bắt đầu transaction
            conn.setAutoCommit(false);

            // 1. Kiểm tra số dư
            String checkSql = "SELECT Balance FROM Accounts WHERE AccountId = ?";
            double senderBalance = 0;

            try (PreparedStatement ps = conn.prepareStatement(checkSql)) {

                // Kiểm tra tài khoản gửi
                ps.setString(1, senderId);
                ResultSet rs = ps.executeQuery();

                if (!rs.next()) {
                    throw new SQLException("Tài khoản gửi không tồn tại!");
                }

                senderBalance = rs.getDouble("Balance");

                if (senderBalance < amount) {
                    throw new SQLException("Không đủ số dư!");
                }
            }

            // 2. Gọi Stored Procedure (CallableStatement)
            String callSql = "{CALL sp_UpdateBalance(?, ?)}";

            try (CallableStatement cs = conn.prepareCall(callSql)) {

                // Trừ tiền người gửi
                cs.setString(1, senderId);
                cs.setDouble(2, -amount);
                cs.execute();

                // Cộng tiền người nhận
                cs.setString(1, receiverId);
                cs.setDouble(2, amount);
                cs.execute();
            }

            // 3. Commit
            conn.commit();
            System.out.println("Chuyển khoản thành công!");

            // 4. Hiển thị kết quả
            String resultSql = "SELECT * FROM Accounts WHERE AccountId IN (?, ?)";

            try (PreparedStatement ps = conn.prepareStatement(resultSql)) {
                ps.setString(1, senderId);
                ps.setString(2, receiverId);

                ResultSet rs = ps.executeQuery();

                System.out.println("\nKết quả sau giao dịch:");
                while (rs.next()) {
                    System.out.println(
                            rs.getString("AccountId") + " | " +
                                    rs.getString("FullName") + " | " +
                                    rs.getDouble("Balance")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Giao dịch thất bại!");

        }
    }
}