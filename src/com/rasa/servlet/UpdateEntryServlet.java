package com.rasa.servlet;

import com.rasa.service.ServiceEntry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateEntryServlet")
public class UpdateEntryServlet extends HttpServlet {

    private ServiceEntry serviceEntry;

    @Override
    public void init() throws ServletException {
        super.init();
        serviceEntry = new ServiceEntry();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String entryDate = request.getParameter("entryDate");
        String accidentDate = request.getParameter("accidentDate");
        String repair = request.getParameter("repair");
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

        isSuccess = serviceEntry.updateServiceEntry(serviceId,repair,entryDate,accidentDate,hasCustomerNoObjection,hasInsuranceNoObjection,hasClaimForm);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
