package com.example.firstwebapplicationjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    //Establishing the connection with mySQL Database
    public static Connection getDbConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatrainee", "kamran", "kamran");//
            System.out.println("Connection is Successfully Created");
        } catch (Exception e) {
            System.out.println("Connection not established");
        }
        return conn;
    }
}
