package com.example.firstwebapplicationjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class TraineesDAO {
    private static final String SELECT_USER_BY_ID = "select ID,FIRSTNAME,LASTNAME,EMAIL,AGE, GENDER, PHONENO, ADDRESS from `javatrainee`.`trainees` where id =?";
    private static final String INSERT_USERS_SQL = "INSERT INTO `javatrainee`.`trainees` (FIRSTNAME, LASTNAME, EMAIL, AGE, GENDER, PHONENO, ADDRESS) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE_USERS_SQL = "delete from `javatrainee`.`trainees` where id = ?;";
    private static final String UPDATE_USERS_SQL = "update `javatrainee`.`trainees` set FIRSTNAME = ?,LASTNAME= ?, EMAIL =?, AGE =?,GENDER=?, PHONENO=?, ADDRESS=?  where id = ?;";

    public JavaTrainees selectUser(int id) {
        JavaTrainees javaTrainees = null;
        // Step 1: Establishing a Connection
        try (Connection connection = DatabaseConnection.getDbConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("id");
                String firstName = rs.getString("FIRSTNAME");
                String lastName = rs.getString("LASTNAME");
                String email = rs.getString("email");
                int age = rs.getInt("AGE");
                String gender = rs.getString("GENDER");
                String phoneNo = rs.getString("PHONENO");
                String address = rs.getString("ADDRESS");
                javaTrainees = new JavaTrainees(ID, firstName, lastName, email, age, gender, phoneNo, address);
            }
        } catch (SQLException e) {
            System.out.println(e.getClass().getName());
        }
        return javaTrainees;
    }

    public List<JavaTrainees> selectAllUsers() throws SQLException, InputMismatchException, IndexOutOfBoundsException {
        List<JavaTrainees> trainees = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = DatabaseConnection.getDbConnection().prepareStatement("SELECT * from  `javatrainee`.`trainees`")) {
//            System.out.println(preparedStatement);
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

    public void insertUser(JavaTrainees javaTrainees) throws SQLException {
//        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DatabaseConnection.getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, javaTrainees.getFirstName());
            preparedStatement.setString(2, javaTrainees.getLastName());
            preparedStatement.setString(3, javaTrainees.getEmail());
            preparedStatement.setInt(4, javaTrainees.getAge());
            preparedStatement.setString(5, javaTrainees.getGender());
            preparedStatement.setString(6, javaTrainees.getPhoneNo());
            preparedStatement.setString(7, javaTrainees.getAddress());
/*            System.out.println(javaTrainees.getFirstName() + " " + javaTrainees.getLastName() + " " + javaTrainees.getEmail() + " " +
                    javaTrainees.getAge() + " " + javaTrainees.getGender() + " " + javaTrainees.getPhoneNo() + " " + javaTrainees.getAddress() + " " + javaTrainees.getId());*/
//            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getClass());
        }
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DatabaseConnection.getDbConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(JavaTrainees javaTrainees) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DatabaseConnection.getDbConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setString(1, javaTrainees.getFirstName());
            preparedStatement.setString(2, javaTrainees.getLastName());
            preparedStatement.setString(3, javaTrainees.getEmail());
            preparedStatement.setInt(4, javaTrainees.getAge());
            preparedStatement.setString(5, javaTrainees.getGender());
            preparedStatement.setString(6, javaTrainees.getPhoneNo());
            preparedStatement.setString(7, javaTrainees.getAddress());
            preparedStatement.setInt(8, javaTrainees.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
