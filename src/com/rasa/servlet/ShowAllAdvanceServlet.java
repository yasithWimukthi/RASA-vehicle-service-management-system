package com.rasa.servlet;

import com.rasa.model.EmployeeAdvance;
import com.rasa.service.EmployeeAdvanceService;
import com.rasa.service.EmployeePaymentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowAllEmployeeServlet")
public class ShowAllAdvanceServlet extends HttpServlet {

     EmployeeAdvanceService employeeAdvanceService = new EmployeeAdvanceService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<EmployeeAdvance> list = new ArrayList<EmployeeAdvance>();
        try{
            list = employeeAdvanceService.showAllAdvance();

            request.setAttribute("list",list);

            RequestDispatcher dis = request.getRequestDispatcher("allEmployeePayment.jsp");
            dis.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
