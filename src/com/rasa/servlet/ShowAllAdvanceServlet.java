package com.rasa.servlet;

import com.rasa.model.EmployeeAdvance;
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

@WebServlet(name = "ShowAllEmployeeServlet")
public class ShowAllAdvanceServlet extends HttpServlet {

     EmployeeAdvanceService employeeAdvanceService = new EmployeeAdvanceService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<EmployeeAdvance> list = new ArrayList<>();
        try{

            list = employeeAdvanceService.showAllAdvance();

            request.setAttribute("list",list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
