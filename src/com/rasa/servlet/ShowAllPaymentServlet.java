package com.rasa.servlet;

import com.rasa.model.EmployeeAdvance;
import com.rasa.model.EmployeePayment;
import com.rasa.service.EmployeeAdvanceService;
import com.rasa.service.EmployeePaymentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowAllPaymentServlet")
public class ShowAllPaymentServlet extends HttpServlet {

    EmployeePaymentService employeePaymentService = new EmployeePaymentService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<EmployeePayment> list = new ArrayList<>();
        try{

            list = employeePaymentService.showAllPayment()  ;

            request.setAttribute("list",list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

