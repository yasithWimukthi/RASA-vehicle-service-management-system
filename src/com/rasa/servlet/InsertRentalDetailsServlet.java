package com.rasa.servlet;

import com.rasa.model.Rent;
import com.rasa.service.IRentCarService;
import com.rasa.service.RentCarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/InsertRentalDetailsServlet")
public class InsertRentalDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("mobile");
        String address = request.getParameter("address");
        String pickUpDate = request.getParameter("pickupdate");
        String dropOffDate = request.getParameter("dropoffdate");
        double rentalPrice = Double.parseDouble(request.getParameter("rentalprice"));
        int registrationNumber = Integer.parseInt(request.getParameter("registrationnumber"));
        int operatorID = 2;

        System.out.println(registrationNumber);

        Rent rent = new Rent(firstName, lastName, email, phone, address, pickUpDate, dropOffDate, rentalPrice, registrationNumber, operatorID);

        IRentCarService iRentCarService = new RentCarService();
        try {
            boolean isAdded = iRentCarService.insertRentalDetails(rent);
            if(!isAdded){
                request.getRequestDispatcher("rentalDetails.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
