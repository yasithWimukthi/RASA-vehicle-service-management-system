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

@WebServlet("/GetServiceDetailsServlet")
public class GetServiceDetailsServlet extends HttpServlet {

    private ServiceEntry serviceEntry;
    private ClientService clientService;
    private VehicleService vehicleService;
    private Repair repair;
    private Vehicle vehicle;
    private Customer customer;

    @Override
    public void init() throws ServletException {
        super.init();
        serviceEntry = new ServiceEntry();
        clientService = new ClientService();
        vehicleService = new VehicleService();
        repair = new Repair();
        vehicle = new Vehicle();
        customer = new Customer();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String serviceID = request.getParameter("serviceID");
        repair = serviceEntry.getRepairByServiceID(Integer.parseInt(serviceID));
        customer = clientService.searchByNic(repair.getNICno().toUpperCase());
        vehicle = vehicleService.searchByRegistrationNumber(repair.getVehicleRegistrationNo().toUpperCase());

        request.setAttribute("repair",repair);
        request.setAttribute("client",customer);
        request.setAttribute("vehicle",vehicle);
        request.setAttribute("isUpdate",false);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/entry.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
