package com.example.firstwebapplicationjava;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//@WebServlet(name = "ListOfUsers", value = "/TraineesList")
@WebServlet("/")
public class TraineesServlet extends HttpServlet {

    private TraineesDAO traineesDAO;

    public void init() {
        traineesDAO = new TraineesDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/list":
                    listUser(request, response);
                    break;
                default:
                    System.out.println("Nothing returned from case");
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<JavaTrainees> listUser = traineesDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("traineesList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("createNewUser.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String phoneNo = request.getParameter("phoneNo");
        String address = request.getParameter("address");
//        System.out.println(firstName+" "+lastName+" "+email+" "+age+" "+gender+" "+phoneNo+" "+address);
        JavaTrainees javaTrainees = new JavaTrainees(firstName, lastName, email, age, gender, phoneNo, address);
        traineesDAO.insertUser(javaTrainees);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        traineesDAO.deleteUser(id);
        response.sendRedirect("list");
    }
}