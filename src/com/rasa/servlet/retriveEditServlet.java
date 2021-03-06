package com.rasa.servlet;

import com.rasa.model.paymentList;

import com.rasa.service.paymentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/retriveEditServlet")

public class retriveEditServlet extends HttpServlet {
    private paymentService paydao;

    public void init() {
        this.paydao = new paymentService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int payId = Integer.parseInt(request.getParameter("payId"));
        System.out.println(payId);
        paymentList p =  paydao.selectPayment(payId);

        request.setAttribute("payId",p.getPayId());
        System.out.println("after set"+payId);
        request.setAttribute("registrationNumber",p.getRegistrationNumber());

        request.setAttribute("estimateAmount",p.getEstimateAmount());
        request.setAttribute("cash",p.getCash());
        request.setAttribute("paymentDate",p.getPaymentDate());

        request.getRequestDispatcher("editPayment.jsp").forward(request,response);

    }



}

