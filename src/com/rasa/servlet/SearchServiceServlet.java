package com.rasa.servlet;

import com.rasa.model.Repair;
import com.rasa.service.ServiceEntry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SearchServiceServlet")
public class SearchServiceServlet extends HttpServlet {

    ServiceEntry serviceEntry;

    @Override
    public void init() throws ServletException {
        super.init();
        serviceEntry = new ServiceEntry();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        String key = request.getParameter("key");
//        String type = request.getParameter("type");
//        List <Repair> repairsList;
//
//        if (type.equals("nicNumber")){
//            repairsList = serviceEntry.searchByRegistrationNic(key);
//        }else{
//            repairsList = serviceEntry.searchByRegistrationNumber(key);
//        }
//
//        RequestDispatcher dispatcher ;
//        request.setAttribute("services",repairsList);
//        dispatcher = getServletContext().getRequestDispatcher("/searchservice.jsp");
//        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String key = request.getParameter("key");
        String type = request.getParameter("type");
        List <Repair> repairsList;
        boolean isEmpty = false;

        if (type.equals("nicNumber")){
            repairsList = serviceEntry.searchByRegistrationNic(key);
        }else{
            repairsList = serviceEntry.searchByRegistrationNumber(key);
        }

        if (repairsList.isEmpty()){
            isEmpty = true;
        }

        RequestDispatcher dispatcher ;
        request.setAttribute("services",repairsList);
        request.setAttribute("isEmpty",isEmpty);
        dispatcher = getServletContext().getRequestDispatcher("/searchservice.jsp");
        dispatcher.forward(request, response);

    }
}
