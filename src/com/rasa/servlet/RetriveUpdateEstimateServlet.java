package com.rasa.servlet;

import com.rasa.model.RepairComponent;
import com.rasa.service.Iworkprogress_service;
import com.rasa.service.Workprogress_service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RetriveUpdateEstimateServlet")
public class RetriveUpdateEstimateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ser_id = request.getParameter("serId");
        String Item_id = request.getParameter("Item_id");
        String Item_name = request.getParameter("ser_name");

        Iworkprogress_service iworkprogress_service = new Workprogress_service();
        try {
           RepairComponent repairComponent= iworkprogress_service.retriveRepairComponentById(ser_id,Item_id,Item_name);
           request.setAttribute("Object_rcom",repairComponent);
           request.getRequestDispatcher("addrepaircomponent.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
