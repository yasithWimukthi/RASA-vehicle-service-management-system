package com.rasa.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddAdvanceServlet")
public class AddAdvanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int regID = Integer.parseInt(request.getParameter("regID"));
        int adminID = Integer.parseInt(request.getParameter("adminID"));
        Date date = Date.valueOf(request.getParameter("date"));
        double amount = Double.parseDouble(request.getParameter("amount"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
