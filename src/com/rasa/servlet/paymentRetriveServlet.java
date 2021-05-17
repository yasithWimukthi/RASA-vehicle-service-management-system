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


@WebServlet(name = "paymentRetriveServlet")
public class paymentRetriveServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    private paymentService paydao;

    public void init() {
        this.paydao = new paymentService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            paymentService load = new  paymentService();
            paymentList pay= load.showLatestPayment();


            request.setAttribute("payId",pay.getPayId());
            request.setAttribute("registrationNumber",pay.getRegistrationNumber());
            request.setAttribute("estimateAmount",pay.getEstimateAmount());
            request.setAttribute("cash",pay.getCash());
            request.setAttribute("paymentDate",pay.getPaymentDate());


            request.getRequestDispatcher("paymentList.jsp").forward(request,response);



        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    }

