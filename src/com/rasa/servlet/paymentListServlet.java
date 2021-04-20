package com.rasa.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import com.rasa.model.paymentList;
import com.rasa.service.paymentService;

@WebServlet("/paymentListServlet")
public class paymentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String registrationNumber = request.getParameter("registrationNumber");

        double estimateAmount = Double.parseDouble(request.getParameter("estimateAmount"));

        double cash = Double.parseDouble(request.getParameter("cash"));
        Date paymentDate = Date.valueOf(request.getParameter("paymentDate"));
        int serivceID = Integer.parseInt(request.getParameter("serivceID"));



        paymentList newPayment = new paymentList(registrationNumber,estimateAmount,cash,paymentDate,serivceID);
        try {
            paymentService.addPayment(newPayment);
            response.sendRedirect("paymentlist.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}

