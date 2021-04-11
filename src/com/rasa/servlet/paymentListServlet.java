package com.rasa.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "paymentListServlet")
public class paymentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getServletPath();

        switch(action){
            case "/insert":
                   addPayment(request, response);
                break;
            case "/delete":
                   deletePayment(request,response);
                   break;
            case "/update":
                   updatePayment(request,response);
                   break;
            default:
                paymentList(request,response);
                break;


        }
    }

    private void paymentList(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updatePayment(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deletePayment(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addPayment(HttpServletRequest request, HttpServletResponse response) {
    }
}
