/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jefinho.products.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import jefinho.products.models.Product;

/**
 *
 * @author João Salomão
 */
public class ProductDAO {
    static java.sql.Connection con = Connection.getConexao();

    public static boolean add(Product p) {
        try {
            String sql = "INSERT INTO products(code, description, price, state) VALUES(?, ?, ?, ?)";
            String returnColunm[] = {"id"};
            
            PreparedStatement st = con.prepareStatement(sql, returnColunm);
            st.setString(1, p.getCode());
            st.setString(2, p.getDescription());
            st.setDouble(3, p.getPrice());
            st.setBoolean(4, p.getState());
            st.executeUpdate();
            
            ResultSet rs;
            rs = st.getGeneratedKeys();
            rs.next();
           
            p.setId(rs.getInt(1));
            return true;
        } catch(SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public static boolean update(Product p) {
        try {
            String sql = "UPDATE products SET code = ?, description = ? WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, p.getCode());
            st.setString(2, p.getDescription());
            st.setInt(3, p.getId());
            
            st.executeUpdate();
            return true;
        } catch(SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public static boolean delete(Product p) {
        try {
            String sql = "DELETE FROM products WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setInt(1, p.getId());
            
            st.executeUpdate();
            return true;
        } catch(SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public static Product show(int id) {
        try {
            String sql = "SELECT * FROM products WHERE id = "+id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            rs.next();
            
            String code = rs.getString("code");
            String description = rs.getString("description");
            double price = rs.getDouble("price");
            boolean state = rs.getBoolean("state");
            
            return new Product(id, code, description, price, state);
  
        } catch(SQLException e) {
            System.out.println(e);
        }
        return null;
    }
   
    public static ArrayList<Product> index() {
        ArrayList<Product> products = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM products";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                Product p;
                
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                boolean state = rs.getBoolean("state");

                p = new Product(id, code, description, price, state);
                products.add(p);
            }   
            
            return products;
        } catch(SQLException e) {
            System.out.println(e);
        }
        
        return null;
    }
}
