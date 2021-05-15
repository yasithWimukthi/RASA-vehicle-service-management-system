package com.rasa.servlet;

import com.itextpdf.text.DocumentException;
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
import java.sql.SQLException;

@WebServlet("/CreateEntryReportServlet")
public class CreateEntryReportServlet extends HttpServlet {

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
        int serviceId = Integer.parseInt(request.getParameter("repairId"));
        boolean isSuccess = false;

        repair = serviceEntry.getRepairByServiceID(serviceId);
        customer = clientService.searchByNic(repair.getNICno().toUpperCase());
        vehicle = vehicleService.searchByRegistrationNumber(repair.getVehicleRegistrationNo().toUpperCase());

        try {
            isSuccess = serviceEntry.generateServiceReport(customer,vehicle,repair);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
        e.printStackTrace();
        }

        request.setAttribute("repair",repair);
        request.setAttribute("client",customer);
        request.setAttribute("vehicle",vehicle);
        request.setAttribute("isUpdate",false);
        request.setAttribute("isCreate",true);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/entry.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
