package com.rasa.servlet;

import com.rasa.model.Employee;
import com.rasa.service.employeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ViewProfileServlet")
public class ViewProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeID = request.getParameter("ID");
            System.out.println(request.getParameter("ID"));
        employeeService service = new employeeService();


        Employee emp = service.viewEmployeeProfile(Integer.parseInt(employeeID));
        request.setAttribute("employeeID",emp.getEmployeeID());
        request.setAttribute("fname",emp.getFname());
        request.setAttribute("lname",emp.getLname());
        request.setAttribute("gender",emp.getGender());
        request.setAttribute("DOB",emp.getDOB());
        request.setAttribute("NIC",emp.getNIC());
        request.setAttribute("basicSalary",emp.getBasicSalary());
        request.setAttribute("mobile",emp.getMobile());
        request.setAttribute("email",emp.getEmail());
        request.setAttribute("address",emp.getAddress());

        System.out.println("servlet"+request.getParameter("employeeID"));
        request.getRequestDispatcher("employeeprofile.jsp").forward(request,response);

    }
}
