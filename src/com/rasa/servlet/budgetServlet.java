package com.rasa.servlet;

import com.rasa.model.Budget;
import com.rasa.service.budgetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/budgetServlet")
public class budgetServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        budgetService budgetservice = new budgetService();
        Budget b =budgetservice.AllMethods(year,month);
        System.out.println(b.getRepairAmount());
        System.out.println(b.getRentalAmount());
        System.out.println(b.getProfit());
        System.out.println(b.getInventoryExpenses());
        System.out.println(b.getEmpPayments());

        request.setAttribute("income",b.getTotIncome());

        request.setAttribute("Ramount",b.getRepairAmount());
        request.setAttribute("rentalAmount",b.getRentalAmount());
        request.setAttribute("expenses",b.getTotExpenses());

        request.setAttribute("inventoryExpenses",b.getInventoryExpenses());
        request.setAttribute("empPayments",b.getEmpPayments());
        request.setAttribute("profit",b.getProfit());


        request.getRequestDispatcher("budget.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
