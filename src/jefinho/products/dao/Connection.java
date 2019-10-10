/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jefinho.products.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author João Salomão
 */
public class Connection {
    private static java.sql.Connection connection;
    private static final String serverName = "localhost";
    private static final String mydatabase = "aula0210";
    private static final String username = "mysql";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://" + serverName+ "/" + mydatabase+"?useTimezone=true&serverTimezone=UTC";
    
    public static java.sql.Connection getConnection(){
        if ( connection == null){
            try {
                String driverName = "com.mysql.cj.jdbc.Driver";
                Class.forName(driverName);
                connection = DriverManager.getConnection(url,username, password);
                
            } catch(ClassNotFoundException e) {
                
                System.out.println(e);
                System.out.println("A classe não foi encontrada");
                
            }catch (SQLException e){
                System.out.println(e);
            }
        }
        return connection;
    }
    public static boolean encerraConexao() {
        try {
            connection.close();
            return true;
        } catch(SQLException e) {
            return false;
        }
    }

    static java.sql.Connection getConexao() {
        getConnection();
        return connection;
    }
}

