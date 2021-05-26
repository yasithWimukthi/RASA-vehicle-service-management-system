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
        int sid = Integer.parseInt(request.getParameter("sid"));
        Iworkprogress_service iworkprogress_service = new Workprogress_service();
        try {
            Boolean isCreate = iworkprogress_service.Createprogress(sid);
            if(!isCreate){
                request.setAttribute("sid",sid);
                request.getRequestDispatcher("add_services.jsp").forward(request,response);
            }
            else{
                request.setAttribute("sid",sid);
                request.getRequestDispatcher("add_services.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
