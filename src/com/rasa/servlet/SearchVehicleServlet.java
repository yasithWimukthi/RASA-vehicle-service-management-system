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

@WebServlet("/SearchVehicleServlet")
public class SearchVehicleServlet extends HttpServlet {

    VehicleService vehicleService;

    @Override
    public void init() throws ServletException {
        super.init();
        vehicleService = new VehicleService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String registrationNumber = request.getParameter("registrationNumber");
        String nic = request.getParameter("nic");

        Vehicle vehicle = vehicleService.searchByRegistrationNumber(registrationNumber);

        request.setAttribute("vehicle",vehicle);
        request.setAttribute("nic",nic);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/vehiclereg.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
