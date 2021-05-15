package com.rasa.servlet;

import com.rasa.model.Customer;
import com.rasa.model.Repair;
import com.rasa.model.Vehicle;
import com.rasa.service.ClientService;
import com.rasa.service.ServiceEntry;
import com.rasa.service.VehicleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateVehicleServlet")
public class UpdateVehicleServlet extends HttpServlet {

    private VehicleService vehicleService;
    private Repair repair;
    private Vehicle vehicle;
    private Customer customer;
    private ServiceEntry serviceEntry;
    private ClientService clientService;

    @Override
    public void init() throws ServletException {
        super.init();
        vehicleService = new VehicleService();
        serviceEntry = new ServiceEntry();
        clientService = new ClientService();
        repair = new Repair();
        vehicle = new Vehicle();
        customer = new Customer();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String regID = request.getParameter("registrationNumber");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String color = request.getParameter("color");
        int serviceId = Integer.parseInt(request.getParameter("repairId"));
        String nic = request.getParameter("nic");
        int manufactureYear = Integer.parseInt(request.getParameter("manufactureYear"));

        boolean isSuccess = false;

        isSuccess = vehicleService.updateVehicle(regID,manufactureYear,brand,model,color);

        repair = serviceEntry.getRepairByServiceID(serviceId);
        customer = clientService.searchByNic(repair.getNICno().toUpperCase());
        vehicle = vehicleService.searchByRegistrationNumber(repair.getVehicleRegistrationNo().toUpperCase());

        request.setAttribute("repair",repair);
        request.setAttribute("client",customer);
        request.setAttribute("vehicle",vehicle);
        request.setAttribute("isUpdate",true);
        request.setAttribute("isCreate",false);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/entry.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
