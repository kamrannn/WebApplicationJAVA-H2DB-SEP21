package com.example.firstwebapplicationjava;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListOfUsers", value = "/TraineesList")
public class TraineesServlet extends HttpServlet {

    public void init() {
    }

    //Printing all the Java Trainees in this method using PrintWriter
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.println("<html><body>");
        try {
            Statement stmt = DatabaseConnection.getDbConnection().createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from TRAINEES");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>TraineeID</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Age</th>" +
                    "<th>Gender</th><th>PhoneNo</th><th>Address</th></tr>");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString("FIRSTNAME");
                String lastName = resultSet.getString("LASTNAME");
                String email = resultSet.getString("EMAIL");
                int age = resultSet.getInt("AGE");
                String gender = resultSet.getString("GENDER");
                String phoneNo = resultSet.getString("PHONENO");
                String address = resultSet.getString("ADDRESS");
                out.println("<tr><td>" + id + "</td><td>" + firstName + "</td><td>" + lastName + "</td><td>" + email
                        + "</td><td>" + age + "</td><td>" + gender + "</td><td>" + phoneNo + "</td><td>" + address + "</td></tr>");
            }
            out.println("</table>");
            out.println("</html></body>");
            DatabaseConnection.getDbConnection().close();
        } catch (Exception e) {
            out.println("error");
        }
    }
}
