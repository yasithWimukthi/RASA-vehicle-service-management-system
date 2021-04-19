package com.rasa.servlet;

import com.rasa.model.EmployeeAdvance;
import com.rasa.service.EmployeeAdvanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/AddAdvanceServlet")
public class AddAdvanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empID = Integer.parseInt(request.getParameter("empID"));
       // int adminID = Integer.parseInt(request.getParameter("adminID"));
       // Date date = Date.valueOf(request.getParameter("date"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        EmployeeAdvance advance = new EmployeeAdvance();
        advance.setEmpID(empID);
       // advance.setAdminID(adminID);
       // advance.setDate(date);
        advance.setAmount(amount);

        EmployeeAdvanceService service=new EmployeeAdvanceService();
        service.addAdvance(advance);
        response.sendRedirect("employeePayment.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}