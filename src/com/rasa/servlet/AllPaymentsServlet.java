package com.rasa.servlet;

import com.rasa.model.paymentList;
import com.rasa.service.paymentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AllPaymentsServlet")
public class AllPaymentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    private paymentService paydao;

    public void init() {
        this.paydao = new paymentService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


            List<paymentList> payList = paydao.selectAllPayment();


            request.setAttribute("payList", payList);

            RequestDispatcher dis = request.getRequestDispatcher("allPayments.jsp");
            dis.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
