package dao;

import utils.DBConnection;
import java.sql.*;

public class OrderDAO {

    private ProductDAO productDAO = new ProductDAO();

    public void placeOrder(int userId, int productId, int quantity) {
        Connection conn = null;

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            // 1. check stock
            int stock = productDAO.getStock(conn, productId);

            if (stock < quantity) {
                throw new RuntimeException("Hết hàng");
            }

            // 2. update stock
            productDAO.updateStock(conn, productId, quantity);

            // 3. create order
            String insertOrder = "INSERT INTO Orders(user_id) VALUES (?)";
            PreparedStatement psOrder = conn.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS);
            psOrder.setInt(1, userId);
            psOrder.executeUpdate();

            ResultSet rs = psOrder.getGeneratedKeys();
            int orderId = 0;
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            // 4. insert order detail (batch)
            String insertDetail = "INSERT INTO Order_Details(order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
            PreparedStatement psDetail = conn.prepareStatement(insertDetail);

            double price = productDAO.getPrice(conn, productId);

            psDetail.setInt(1, orderId);
            psDetail.setInt(2, productId);
            psDetail.setInt(3, quantity);
            psDetail.setDouble(4, price);

            psDetail.addBatch();
            psDetail.executeBatch();

            conn.commit();
            System.out.println(Thread.currentThread().getName() + " ✅ SUCCESS");

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ❌ FAIL: " + e.getMessage());

        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}