package dao;

import utils.DBConnection;
import java.sql.*;

public class ProductDAO {

    public int getStock(Connection conn, int productId) throws SQLException {
        String sql = "SELECT stock FROM Products WHERE product_id = ? FOR UPDATE";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, productId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("stock");
        }
        return 0;
    }

    public void updateStock(Connection conn, int productId, int quantity) throws SQLException {
        String sql = "UPDATE Products SET stock = stock - ? WHERE product_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, quantity);
        ps.setInt(2, productId);
        ps.executeUpdate();
    }

    public double getPrice(Connection conn, int productId) throws SQLException {
        String sql = "SELECT price FROM Products WHERE product_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, productId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getDouble("price");
        }
        return 0;
    }
}
