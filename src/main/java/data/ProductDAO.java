package data;

import bussiness.Product;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            String query = "SELECT * FROM ProductList";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Product p = new Product(
                    rs.getString("code"),
                    rs.getString("descriptions"),
                    rs.getDouble("price")
                );
                products.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return products;
    }
    
    public static Product getProduct(String code) {
        Product product = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM ProductList WHERE code = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, code);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                product = new Product(
                    rs.getString("code"),
                    rs.getString("descriptions"),
                    rs.getDouble("price")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return product;
    }
}
