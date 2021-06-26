package com.rasa.servlet;

import com.itextpdf.text.DocumentException;
import com.rasa.service.budgetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/BudgetReportServlet")
public class BudgetReportServlet extends HttpServlet {
    private budgetService bs;

    public void init() {
        this.bs = new budgetService();
    }

    public BudgetReportServlet(){
        super();

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String year = (String) session.getAttribute("year");
        String month = (String) session.getAttribute("month");


        try {

            boolean isDownload =  bs.BudgetReport(year, month);

            if(isDownload){
                request.setAttribute("IsConfirmed","Download Completed");
                request.getRequestDispatcher("budget.jsp").forward(request,response);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
