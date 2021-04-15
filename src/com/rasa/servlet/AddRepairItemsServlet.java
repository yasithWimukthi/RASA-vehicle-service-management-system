package com.rasa.servlet;

import com.rasa.model.RepairComponent;
import com.rasa.model.RepairService;
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

@WebServlet("/AddRepairItemsServlet")
public class AddRepairItemsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String R_ItemId = request.getParameter("RItems");
          int amount =Integer.parseInt(request.getParameter("estimateAmount"));
          String ser_id = request.getParameter("ser_id");

          RepairService repairService = new RepairService();
          VehicleComponent vehicleComponent = new VehicleComponent();

          repairService.setSer_Id(ser_id);
          vehicleComponent.setV_itemId(R_ItemId);

          RepairComponent repairComponent = new RepairComponent(repairService,amount,vehicleComponent);
          Iworkprogress_service iworkprogress_service = new Workprogress_service();
        try {
            Boolean res = iworkprogress_service.addRepairComponent(repairComponent);
            if(!res){
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
