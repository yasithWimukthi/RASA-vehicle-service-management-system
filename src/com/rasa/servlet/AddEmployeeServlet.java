package com.rasa.servlet;

import com.rasa.model.Employee;
import com.rasa.service.employeeService;
import jdk.jfr.consumer.RecordedObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.sql.Date;

import static java.lang.Integer.parseInt;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String DOB = request.getParameter("DOB");
        String NIC = request.getParameter("NIC");
        String basicSalary = request.getParameter("basicSalary");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String joinDate = request.getParameter("joinDate");

        Employee employee = new Employee(fname, lname, gender, DOB, NIC, basicSalary, mobile, email, address, joinDate);
        try {

            employeeService empS = new employeeService();
            empS.addEmployee(employee);

            response.sendRedirect("employeedetails.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}