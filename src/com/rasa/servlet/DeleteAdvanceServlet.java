package com.rasa.servlet;

import com.rasa.service.EmployeeAdvanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteAdvanceServlet")
public class DeleteAdvanceServlet extends HttpServlet {

    private EmployeeAdvanceService service;

    public void init() {
        service = new EmployeeAdvanceService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            service.deleteAdvance();
            response.sendRedirect("employeePayment.jsp");
        } catch ( Exception e) {

            e.printStackTrace();
        }
    }
}
