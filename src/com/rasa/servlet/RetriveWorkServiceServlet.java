package com.rasa.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/RetriveWorkServiceServlet")
public class RetriveWorkServiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String ser_id = request.getParameter("ser_id");
        String ser_name = request.getParameter("ser_name");

        //store into session varible this is used inside addrepaircomponent.jsp page
        session.setAttribute("serviceId",ser_id);
        session.setAttribute("serviceName",ser_name);
        //redirect to the addrepaircomponent.jsp page
        request.getRequestDispatcher("addrepaircomponent.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
