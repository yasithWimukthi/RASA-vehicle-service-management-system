package com.rasa.servlet;

import com.rasa.model.Employee;
import com.rasa.service.employeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/EmployeeUpdate")
public class EmployeeUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //int employeeID= Integer.parseInt(request.getParameter("employeeID"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String DOB = request.getParameter("DOB");
        String NIC = request.getParameter("NIC");
        double basicSalary = Double.parseDouble(request.getParameter("basicSalary"));
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        System.out.print(mobile);

        Employee existEmployee = new Employee();

        System.out.println("here"+request.getParameter("ID"));

        existEmployee.setEmployeeID(Integer.parseInt(request.getParameter("ID")));
        existEmployee.setFname(fname);
        existEmployee.setLname(lname);
        existEmployee.setGender(gender);
        existEmployee.setDOB(DOB);
        existEmployee.setNIC(NIC);
        existEmployee.setBasicSalary(basicSalary);
        existEmployee.setMobile(mobile);
        existEmployee.setEmail(email);
        existEmployee.setAddress(address);

        System.out.print(existEmployee.getDOB());


        try {
            employeeService service = new employeeService();
            service.EmployeeUpdate(existEmployee);
            response.sendRedirect("employeedetails.jsp");
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}