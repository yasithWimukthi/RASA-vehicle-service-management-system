package com.rasa.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RetrieveRegNoServlet")
public class RetrieveRegNoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int registrationNumber = Integer.parseInt(request.getParameter("registrationnumber"));

        request.setAttribute("regNo", registrationNumber);
        request.getRequestDispatcher("carRentalForm.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
