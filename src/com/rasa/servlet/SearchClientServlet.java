package com.rasa.servlet;

import com.rasa.model.Customer;
import com.rasa.service.ClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SearchClientServlet")
public class SearchClientServlet extends HttpServlet {

    ClientService clientService;

    @Override
    public void init() throws ServletException {
        super.init();
        clientService = new ClientService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String NICnumber = request.getParameter("nic_number");

        Customer customer = clientService.searchByNic(NICnumber);

        request.setAttribute("customer",customer);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/customerreg.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
