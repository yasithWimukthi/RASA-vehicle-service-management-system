package com.rasa.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoadToAdvanceServlet")
public class LoadToAdvanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

               int id = Integer.parseInt(request.getParameter("id"));

               request.setAttribute("id",id);

        RequestDispatcher dis = request.getRequestDispatcher("advanceForm.jsp");
        dis.forward(request, response);
    }
}
