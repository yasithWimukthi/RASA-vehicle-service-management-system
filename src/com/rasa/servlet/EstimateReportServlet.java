package com.rasa.servlet;

import com.itextpdf.text.DocumentException;
import com.rasa.model.RepairService;
import com.rasa.service.Iworkprogress_service;
import com.rasa.service.Workprogress_service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/EstimateReportServlet")
public class EstimateReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              String pid = request.getParameter("pid");
              Iworkprogress_service iw = new Workprogress_service();
        try {
            ArrayList<RepairService> repairServices = iw.displayServicelist(pid);
            Boolean isDownload = iw.createEstimatePdf(repairServices);

            if(isDownload){
                request.setAttribute("IsConfirmed","Download Completed");
                request.getRequestDispatcher("estimatereportview.jsp").forward(request,response);
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
