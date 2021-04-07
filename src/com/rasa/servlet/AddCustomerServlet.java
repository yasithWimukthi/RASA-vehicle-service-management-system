package com.rasa.servlet;

/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

import com.rasa.service.ClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {

    ClientService clientService;

    @Override
    public void init() throws ServletException {
        super.init();
        clientService = new ClientService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String nic = request.getParameter("nic");
        String address = request.getParameter("address");
        String operatorID = request.getParameter("operatorID");

        boolean isSuccess = clientService.addCustomer(nic,fname,lname,mobile,address,email,operatorID);

        RequestDispatcher dispatcher;
        if(isSuccess){
            dispatcher = getServletContext().getRequestDispatcher("/vehiclereg.jsp");
        }else {
            dispatcher = getServletContext().getRequestDispatcher("/customerreg.jsp");
        }
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
