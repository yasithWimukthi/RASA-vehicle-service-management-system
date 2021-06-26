package com.rasa.servlet;

import com.itextpdf.text.DocumentException;
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
import java.util.ArrayList;

@WebServlet("/RentDetailsReportServlet")
public class RentDetailsReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));

        IRentCarService r = new RentCarService();
        try {
            ArrayList<Rent> list = r.retrieveRentalDetailsByYearAndMonth(year, month);

            Boolean isDownload = r.createRentalDetailsPdf(list, year, month);

            if(isDownload){
                request.setAttribute("IsConfirmed","Download Completed");
                request.getRequestDispatcher("rentalDetails.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
