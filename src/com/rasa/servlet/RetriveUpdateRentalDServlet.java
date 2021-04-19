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

@WebServlet("/RetriveUpdateRentalDServlet")
public class RetriveUpdateRentalDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int rid = Integer.parseInt(request.getParameter("rid"));

        IRentCarService iRentCarService = new RentCarService();

        try {
            Rent rent = iRentCarService.retrieveDataByRentID(rid);
            request.setAttribute("object", rent);
            request.getRequestDispatcher("updateRentalDetails.jsp").forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
