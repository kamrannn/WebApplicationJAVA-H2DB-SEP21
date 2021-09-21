package com.example.firstwebapplicationjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection  {
    //Establishing the connection with H2 Database
    public static Connection getDbConnection() throws SQLException {
        Connection conn =null;
        try{
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/test;", "sa", "");
//            System.out.println("Connection is Successfully Created");
        }catch (Exception e){
            System.out.println("Connection not established");
        }
        return conn;
    }
}
