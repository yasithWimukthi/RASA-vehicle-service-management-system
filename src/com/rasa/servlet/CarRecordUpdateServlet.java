package com.rasa.servlet;

import com.rasa.model.CarRecords;
import com.rasa.service.CarRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CarRecordUpdateServlet")
public class CarRecordUpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int regNumber = Integer.parseInt(request.getParameter("regNumber"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String id = request.getParameter("id");
        String address = request.getParameter("address");
        int phone = Integer.parseInt(request.getParameter("phone"));;
        String email = request.getParameter("email");
        String bookNumber = request.getParameter("bookNumber");
        String model = request.getParameter("model");
        int seatAmount = Integer.parseInt(request.getParameter("seatAmount"));
        Float distance = Float.parseFloat(request.getParameter("distance"));
        String carType = request.getParameter("carType");


        CarRecords newCar = new CarRecords(regNumber, fname, lname, id, address, phone, email, bookNumber, model, seatAmount, distance, carType);
        try {
            CarRecordService.UpdateCarRecords(newCar);
            response.sendRedirect("CRecords.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}