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

@WebServlet("/AddVehicleServlet")
public class AddVehicleServlet extends HttpServlet {

    VehicleService vehicleService;

    @Override
    public void init() throws ServletException {
        super.init();
        vehicleService = new VehicleService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String regID = request.getParameter("regID");
        String brand = request.getParameter("brand");
        String otherBrand = request.getParameter("otherBrand");
        String model = request.getParameter("model");
        String color = request.getParameter("color");
        String nicNumber = request.getParameter("nicNumber");
        String fullName = request.getParameter("fullName");
        int manufactureYear = Integer.parseInt(request.getParameter("manufactureYear"));
        boolean update = Boolean.parseBoolean(request.getParameter("update"));
        String registrationNumber = request.getParameter("vehicleNumber");

        boolean isSuccess = false;

        System.out.println(update);
        System.out.println(regID);

        if (update){
            if (brand.equals("Other")){
                isSuccess = vehicleService.updateVehicle(registrationNumber,manufactureYear,otherBrand,model,color);
            }else {
                isSuccess = vehicleService.updateVehicle(registrationNumber,manufactureYear,brand,model,color);
            }
        }else {
            if (brand.equals("Other")){
                isSuccess = vehicleService.addVehicle(regID,manufactureYear,otherBrand,model,color,"980971422V");
            }else {
                isSuccess = vehicleService.addVehicle(regID,manufactureYear,brand,model,color,"980971422V");
            }
        }

        if(update){
            request.setAttribute("regID",registrationNumber);
        }else {
            request.setAttribute("regID",regID);
        }

        RequestDispatcher dispatcher;
        //request.setAttribute("regID",registrationNumber);
        //request.setAttribute("fullName",fullName);

        System.out.println(regID);
        System.out.println(fullName);

        if (isSuccess){
            dispatcher = getServletContext().getRequestDispatcher("/addentry.jsp");
        }else {
            dispatcher = getServletContext().getRequestDispatcher("/vehiclereg.jsp");
        }

        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
