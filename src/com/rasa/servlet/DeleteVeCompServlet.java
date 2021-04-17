package com.rasa.servlet;

import com.rasa.service.Iworkprogress_service;
import com.rasa.service.Workprogress_service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteVeCompServlet")
public class DeleteVeCompServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String ser_id = request.getParameter("DserId");
            String item_id = request.getParameter("DItem_id");

            Iworkprogress_service iworkprogress_service = new Workprogress_service();
        try {
            Boolean res = iworkprogress_service.deleteRepairComponent(ser_id,item_id);
            if(!res){
                request.getRequestDispatcher("addrepaircomponent.jsp").forward(request,response);
            }
            else{

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
