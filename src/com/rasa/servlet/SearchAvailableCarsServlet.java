package com.rasa.servlet;

import com.rasa.model.AvailableCars;
import com.rasa.service.IRentCarService;
import com.rasa.service.RentCarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/SearchAvailableCarsServlet")
public class SearchAvailableCarsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Brand = request.getParameter("search");

        IRentCarService iRentCarService = new RentCarService();
        try {
            ArrayList<AvailableCars> list = iRentCarService.searchByBrand(Brand);
            request.setAttribute("object", list);
            request.getRequestDispatcher("searchAvailableCars.jsp").forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
