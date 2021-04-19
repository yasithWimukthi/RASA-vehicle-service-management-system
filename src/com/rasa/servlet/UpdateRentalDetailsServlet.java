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

@WebServlet("/UpdateRentalDetailsServlet")
public class UpdateRentalDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int rentID = Integer.parseInt(request.getParameter("rid"));
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("mobile");
        String address = request.getParameter("address");
        String pickUpDate = request.getParameter("pickupdate");
        String dropOffDate = request.getParameter("dropoffdate");
        double rentalPrice = Double.parseDouble(request.getParameter("rentalprice"));
        int registrationNumber = Integer.parseInt(request.getParameter("registrationnumber"));

        Rent rent = new Rent(rentID, firstName, lastName, email, phone, address, pickUpDate, dropOffDate, rentalPrice, registrationNumber);

        IRentCarService iRentCarService = new RentCarService();
        try {
            boolean isUpdated = iRentCarService.updateRentDetails(rent);
            if(isUpdated){
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
