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

@WebServlet("/UpdateEntryServlet")
public class UpdateEntryServlet extends HttpServlet {

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
        String entryDate = request.getParameter("entryDate");
        String accidentDate = request.getParameter("accidentDate");
        String repairType = request.getParameter("repair");
        String customerNoObjection = request.getParameter("customerNoObjection") ;
        String insuranceNoObjection = request.getParameter("insuranceNoObjection");
        String claimForm = request.getParameter("claimForm");
        int serviceId = Integer.parseInt(request.getParameter("repairId"));
        boolean hasCustomerNoObjection = false;
        boolean hasInsuranceNoObjection = false;
        boolean hasClaimForm = false;
        boolean isSuccess = false;

        try {
            if(customerNoObjection.equals("on")){
                hasCustomerNoObjection = true;
            }
        }catch (NullPointerException e){
            hasCustomerNoObjection = false;
        }

        try {
            if (insuranceNoObjection.equals("on")){
                hasInsuranceNoObjection = true;
            }
        }catch (NullPointerException e){
            hasInsuranceNoObjection = false;
        }

        try {
            if (claimForm.equals("on")){
                hasClaimForm = true;
            }
        }catch (NullPointerException e){
            hasClaimForm = false;
        }

        isSuccess = serviceEntry.updateServiceEntry(serviceId,repairType,entryDate,accidentDate,hasCustomerNoObjection,hasInsuranceNoObjection,hasClaimForm);

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
