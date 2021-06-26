package com.rasa.servlet;

/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/


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

@WebServlet("/UpdateClientServlet")
public class UpdateClientServlet extends HttpServlet {

    private ClientService clientService;
    private VehicleService vehicleService;
    private ServiceEntry serviceEntry;
    private Repair repair;
    private Vehicle vehicle;
    private Customer customer;

    @Override
    public void init() throws ServletException {
        super.init();
        clientService = new ClientService();
        vehicleService = new VehicleService();
        serviceEntry = new ServiceEntry();
        clientService = new ClientService();
        repair = new Repair();
        vehicle = new Vehicle();
        customer = new Customer();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String nic = request.getParameter("nic");
        String address = request.getParameter("address");
        int serviceId = Integer.parseInt(request.getParameter("repairId"));
        String regID = request.getParameter("registrationNumber");
        boolean isSuccess = false;

        isSuccess = clientService.updateCustomer(nic,fname,lname,mobile,address,email);

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
