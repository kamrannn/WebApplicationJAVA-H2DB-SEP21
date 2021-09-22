package com.example.firstwebapplicationjava;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ViewTrainees {

    public static void viewJavaTrainees() {
        try {
            Statement statement = DatabaseConnection.getDbConnection().createStatement();
            String sql = "Select * from TRAINEES";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("\n------------------------------------------------------------\n");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString("FIRSTNAME");
                String lastName = resultSet.getString("LASTNAME");
                String email = resultSet.getString("EMAIL");
                int age = resultSet.getInt("AGE");
                String gender = resultSet.getString("GENDER");
                String phoneNo = resultSet.getString("PHONENO");
                String address = resultSet.getString("ADDRESS");
//                javaTrainees = new JavaTrainees(id, firstName,lastName, email, age,gender, phoneNo, address);
                System.out.println(id +" "+firstName+" "+lastName+" "+ email+" "+ age+" "+gender+" "+ phoneNo+" "+address);
            }
            System.out.println("\n------------------------------------------------------------\n");
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}