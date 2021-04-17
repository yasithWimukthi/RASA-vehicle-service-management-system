package com.rasa.servlet;

import com.rasa.model.VehicleComponent;
import com.rasa.service.Iworkprogress_service;
import com.rasa.service.Workprogress_service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UpdateEstimateServlet")
public class UpdateEstimateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

           String ser_id = request.getParameter("ser_id");
           String item_id = request.getParameter("item_id");
           int estimateAmount = Integer.parseInt(request.getParameter("U_estimate"));
           Iworkprogress_service iworkprogress_service = new Workprogress_service();

        try {
            boolean is_update = iworkprogress_service.UpdateRepairComponent(ser_id,item_id,estimateAmount);
            if(is_update){
                request.getRequestDispatcher("addrepaircomponent.jsp").forward(request,response);
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
