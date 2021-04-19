package com.rasa.servlet;

import com.rasa.model.EmployeePayment;
import com.rasa.service.EmployeePaymentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/AddPaymentServlet")
public class AddPaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empID = Integer.parseInt(request.getParameter("empID"));
        int adminID = Integer.parseInt(request.getParameter("adminID"));
        Date date = Date.valueOf(request.getParameter("date"));
        double bonus = Double.parseDouble(request.getParameter("bonus"));
        double deduct = Double.parseDouble(request.getParameter("deduct"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        EmployeePayment payment= new EmployeePayment();
        payment.setEmpID(empID);
        payment.setAdminID(adminID);
        payment.setDate(date);
        payment.setBonus(bonus);
        payment.setDeduct(deduct);
        payment.setAmount(amount);

        EmployeePaymentService service = new EmployeePaymentService();

        service.addPayement(payment);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
