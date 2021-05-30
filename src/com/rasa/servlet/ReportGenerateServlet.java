package com.rasa.servlet;


import com.rasa.service.EmpPayReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


@WebServlet("/ReportGenerateServlet")
public class ReportGenerateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String type = request.getParameter("type");
        System.out.println(type);
        String opt1="salary";
        String opt2="advance";

        EmpPayReportService service = new EmpPayReportService();


        if(type.equals(opt1)){


            service.salaryReport(year,month);
            response.sendRedirect("empReport.jsp");

        }else if(type.equals(opt2)){
            service.advanceReport(year,month);
            response.sendRedirect("empReport.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}