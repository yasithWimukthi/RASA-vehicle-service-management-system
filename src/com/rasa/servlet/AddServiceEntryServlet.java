package com.rasa.servlet;

/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddServiceEntryServlet")
public class AddServiceEntryServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String registrationNumber = request.getParameter("registrationNumber");
        String entryDate = request.getParameter("entryDate");
        String accidentDate = request.getParameter("accidentDate");
        String repair = request.getParameter("repair");
        String customerNoObjection = request.getParameter("customerNoObjection") ;
        String insuranceNoObjection = request.getParameter("insuranceNoObjection");
        String claimForm = request.getParameter("claimForm");
        boolean hasCustomerNoObjection = false;
        boolean hasInsuranceNoObjection = false;
        boolean hasClaimForm = false;

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



        System.out.println("repair " + repair);
        System.out.println("customerNoObjection " + hasCustomerNoObjection);
        System.out.println("insuranceNoObjection " + hasInsuranceNoObjection);
        System.out.println("Claim Form " + hasClaimForm);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
