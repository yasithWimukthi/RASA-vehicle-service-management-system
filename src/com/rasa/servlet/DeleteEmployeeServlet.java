package com.rasa.servlet;

import com.rasa.service.employeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
    private employeeService service;

    public void init() {
        service = new employeeService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int employeeID= Integer.parseInt(request.getParameter("employeeID"));

        try {
            service.deleteEmployee(employeeID);
            response.sendRedirect("employeedetails.jsp");
        } catch ( Exception e) {

            e.printStackTrace();
        }
    }
}
