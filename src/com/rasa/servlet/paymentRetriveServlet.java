package com.rasa.servlet;

import com.rasa.model.paymentList;
import com.rasa.service.paymentdao;

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


    private paymentdao paydao;

    public void init() {
        this.paydao = new paymentdao ();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


            List<paymentList> payList = paydao.selectAllPayment();





            request.setAttribute("payList", payList);

            RequestDispatcher dis = request.getRequestDispatcher("paymentlist.jsp");
            dis.forward(request, response);

        }catch(Exception e) {
            e.printStackTrace();



        }

    }
}
