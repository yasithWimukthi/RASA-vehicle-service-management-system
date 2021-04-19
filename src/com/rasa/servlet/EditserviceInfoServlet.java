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
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/EditserviceInfoServlet")
public class EditserviceInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get service Id from jsp pages
        String ser_Id = request.getParameter("serId");
        Iworkprogress_service iworkprogress_service = new Workprogress_service();
        try {
            //get data from given service Id
            RepairService ObjectSer = iworkprogress_service.retirvedatabyID(ser_Id);
            request.setAttribute("ObjectServ",ObjectSer);
            request.getRequestDispatcher("add_services.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
