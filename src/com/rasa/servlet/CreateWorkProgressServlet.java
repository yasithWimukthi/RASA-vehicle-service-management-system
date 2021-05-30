package com.rasa.servlet;

import com.rasa.service.Iworkprogress_service;
import com.rasa.service.Workprogress_service;
import com.rasa.util.DBConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CreateWorkProgressServlet")
public class CreateWorkProgressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //gather sid for create new progress Id

        try{
            int sid = Integer.parseInt(request.getParameter("sid"));
            Iworkprogress_service iworkprogress_service = new Workprogress_service();
            String pid = iworkprogress_service.createProgressId(sid);
            request.setAttribute("pid",pid);
            request.getRequestDispatcher("add_services.jsp").forward(request,response);

        }catch (NullPointerException n){
            System.out.println("something wrong !");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
