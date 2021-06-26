package com.rasa.servlet;

import com.rasa.service.ServiceEntry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServiceEntryServlet")
public class DeleteServiceEntryServlet extends HttpServlet {

    private ServiceEntry serviceEntry;

    @Override
    public void init() throws ServletException {
        super.init();
        serviceEntry = new ServiceEntry();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String serviceID = request.getParameter("serviceID");

        boolean isSuccess = serviceEntry.deleteServiceEntry(Integer.parseInt(serviceID));


        if (isSuccess){
            request.setAttribute("isSuccess",true);
        }else{
            request.setAttribute("isSuccess",false);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/searchservice.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
