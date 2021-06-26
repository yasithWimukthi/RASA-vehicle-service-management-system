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
import java.util.List;

@WebServlet("/searchPaymentsServlet")
public class searchPaymentsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date = Date.valueOf(request.getParameter("date"));
        boolean isEmpty = false;


        paymentService payser = new paymentService();


        List<paymentList> payList = payser.searchByDate(date);
        // System.out.println(date);

        if (payList.isEmpty()){
            isEmpty = true;
        }
        request.setAttribute("pay", payList);

        request.setAttribute("isEmpty",isEmpty);

        //System.out.println(payList);
        request.getRequestDispatcher("allPayments.jsp").forward(request,response);


    }
}
