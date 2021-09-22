package com.example.firstwebapplicationjava;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TraineesDAO {

    public List<JavaTrainees> selectAllUsers() {
        List<JavaTrainees> trainees = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = DatabaseConnection.getDbConnection().prepareStatement("SELECT * from  TRAINEES")) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("FIRSTNAME");
                String lastName = rs.getString("LASTNAME");
                String email = rs.getString("email");
                int age = rs.getInt("AGE");
                String gender = rs.getString("GENDER");
                String phoneNo = rs.getString("PHONENO");
                String address = rs.getString("ADDRESS");
                trainees.add(new JavaTrainees(id, firstName, lastName, email, age, gender, phoneNo, address));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return trainees;
    }
}
