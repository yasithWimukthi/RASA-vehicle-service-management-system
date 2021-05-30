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

@WebServlet("/UpdateWorkServiceServlet")
public class UpdateWorkServiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String serId = request.getParameter("serId");
           String Ustatus = request.getParameter("Ustatus");
           int sid = Integer.parseInt(request.getParameter("sid"));
           String des = request.getParameter("Udesc");

           RepairService repairService = new RepairService();
           repairService.setSer_Id(serId);
           repairService.setStatus(Ustatus);
           repairService.setDescription(des);
           Iworkprogress_service iworkprogress_service = new Workprogress_service();
        try {
           Boolean IsUpdate = iworkprogress_service.updateServiceStatus(repairService);
           if(IsUpdate){
               request.setAttribute("sid",sid);
               request.getRequestDispatcher("add_services.jsp").forward(request,response);
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
