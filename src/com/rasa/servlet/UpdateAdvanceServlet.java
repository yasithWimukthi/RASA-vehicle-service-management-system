package com.rasa.servlet;

import com.rasa.model.EmployeeAdvance;
import com.rasa.service.EmployeeAdvanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateAdvanceServlet")
public class UpdateAdvanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int empID = Integer.parseInt(request.getParameter("empID"));
            double amount = Double.parseDouble(request.getParameter("amount"));
            System.out.println(empID);
        System.out.println(amount);


         EmployeeAdvance exist = new EmployeeAdvance();
         exist.setEmpID(empID);
         exist.setAmount(amount);

        try {
            EmployeeAdvanceService service = new EmployeeAdvanceService();
            service.updateAdvance(exist);
            response.sendRedirect("employeePayment.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
