package com.rasa.servlet;

import com.rasa.model.CarRecords;
import com.rasa.service.CarRecordService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CarRecordRetreveServlet")
public class CarRecordRetreveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<CarRecords> CarDetails = CarRecordService.CarRecordRetrieve();
            request.setAttribute("CARDETAILS", "CarDetails");

        }catch(Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dis = request.getRequestDispatcher("CRecord.jsp");
        dis.forward(request, response);

    }
}
