package com.rasa.servlet;


import com.rasa.model.paymentList;

import com.rasa.service.paymentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/paymentEditServlet")
public class paymentEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int payId = Integer.parseInt(request.getParameter("payId"));
        String registrationNumber = request.getParameter("registrationNumber");

        double estimateAmount = Double.parseDouble(request.getParameter("estimateAmount"));

        double cash = Double.parseDouble(request.getParameter("cash"));
        Date paymentDate= Date.valueOf(request.getParameter("paymentDate"));




        paymentList existingPayment = new paymentList(payId,registrationNumber, estimateAmount, cash, paymentDate);
        try {
            paymentService.updatePayment(existingPayment);
            response.sendRedirect("paymentlist.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
