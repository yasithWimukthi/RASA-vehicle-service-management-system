package com.rasa.servlet;

import com.rasa.model.Employee;
import com.rasa.service.EmployeeLoadingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RetriveToPaymentTableServlet")
public class RetrieveToPaymentTableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    EmployeeLoadingService load;

    public void init() {
        this.load = new EmployeeLoadingService ();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            List<Employee> list = load.loadToPaymentTable();

            request.setAttribute("list",list);

            RequestDispatcher dis = request.getRequestDispatcher("employeePayment.jsp");
            dis.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

