/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Categorie;
import models.Product;

/**
 *
 * @author João Salomão
 */
public class CategorieDAO {
    static java.sql.Connection con = Connection.getConexao();
    
    public static boolean add(Categorie c) {
        try {
            String sql = "INSERT INTO categories(name) VALUES(?)";
            String returnColunm[] = {"id"};
            
            PreparedStatement st = con.prepareStatement(sql, returnColunm);
            st.setString(1, c.getName());
            
            st.executeUpdate();
            
            ResultSet rs;
            rs = st.getGeneratedKeys();
            rs.next();
           
            c.setId(rs.getInt(1));
            return true;
        } catch(SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public static boolean update(Categorie c) {
        try {
            String sql = "UPDATE products SET name = ? WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, c.getName());
            st.setInt(2, c.getId());
            
            st.executeUpdate();
            return true;
        } catch(SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public static boolean delete(Categorie c) {
        try {
            String sql = "DELETE FROM products WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setInt(1, c.getId());
            
            st.executeUpdate();
            return true;
        } catch(SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
//    public static Product show(int id) {;
//        try {
//            String sql = "SELECT * FROM products WHERE id = "+id;
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            
//            rs.next();
//            
//            String code = rs.getString("code");
//            String description = rs.getString("description");
//            double price = rs.getDouble("price");
//            boolean state = rs.getBoolean("state");
//            
//            return new Product(id, code, description, price, state);
//  
//        } catch(SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
   
    public static ArrayList<Categorie> index() {
        ArrayList<Categorie> categories = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM categories";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                Categorie c;
                
                int id = rs.getInt("id");
                String name = rs.getString("name");

                c = new Categorie(id, name);
                categories.add(c);
            }   
            
            return categories;
        } catch(SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
