package com.rasa.servlet;

/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

import com.rasa.model.Vehicle;
import com.rasa.service.VehicleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddVehicleServlet")
public class AddVehicleServlet extends HttpServlet {

    VehicleService vehicleService;

    @Override
    public void init() throws ServletException {
        super.init();
        vehicleService = new VehicleService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String regID = request.getParameter("regID");
        String brand = request.getParameter("brand");
        String otherBrand = request.getParameter("otherBrand");
        String model = request.getParameter("model");
        String color = request.getParameter("color");
        String nicNumber = request.getParameter("nicNumber");
        int manufactureYear = Integer.parseInt(request.getParameter("manufactureYear"));

        boolean isSuccess = false;

        if (brand == "Other"){
            isSuccess = vehicleService.addVehicle(regID,manufactureYear,otherBrand,model,color,nicNumber);
        }else {
            isSuccess = vehicleService.addVehicle(regID,manufactureYear,brand,model,color,nicNumber);
        }

        RequestDispatcher dispatcher;
        if (isSuccess){
            dispatcher = getServletContext().getRequestDispatcher("/addentry.jsp");
        }else {
            dispatcher = getServletContext().getRequestDispatcher("/vehiclereg.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
