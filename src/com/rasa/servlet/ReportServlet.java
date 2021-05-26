package com.rasa.servlet;

import com.itextpdf.text.DocumentException;
import com.rasa.service.employeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
    employeeService empl = new employeeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        try {
            empl.employeeProfilePDF(ID);
            request.getRequestDispatcher("employeedetails.jsp").forward(request,response);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
