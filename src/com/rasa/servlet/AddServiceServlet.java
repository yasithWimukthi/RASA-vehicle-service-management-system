package com.rasa.servlet;

import com.rasa.model.RepairService;
import com.rasa.service.Iworkprogress_service;
import com.rasa.service.Workprogress_service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddServiceServlet")
public class AddServiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               String service_type = request.getParameter("services").trim();
               String description = request.getParameter("desc");
               String status = request.getParameter("status").trim();
               String date = request.getParameter("Wdate");
               String pid = request.getParameter("pid").trim();
               //assign values for Repair services class
               RepairService repairService = new RepairService(service_type,description,status,date,pid);
               Iworkprogress_service iworkprogress_service = new Workprogress_service();

        try {
           Boolean Is_add = iworkprogress_service.InsertService(repairService);
           if(!Is_add){
               request.getRequestDispatcher("add_services.jsp").forward(request,response);
           }
           else{
               request.getRequestDispatcher("progress.jsp").forward(request,response);
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
