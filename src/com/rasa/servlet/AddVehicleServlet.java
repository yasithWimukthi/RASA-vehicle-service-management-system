package com.rasa.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddVehicleServlet")
public class AddVehicleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String regID = request.getParameter("regID");
        String brand = request.getParameter("brand");
        String otherBrand = request.getParameter("otherBrand");
        String model = request.getParameter("model");
        String color = request.getParameter("color");
        int manufactureYear = Integer.parseInt(request.getParameter("manufactureYear"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
