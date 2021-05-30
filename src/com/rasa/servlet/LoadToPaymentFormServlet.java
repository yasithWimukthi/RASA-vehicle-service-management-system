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

@WebServlet("/LoadToPaymentFormServlet")
public class LoadToPaymentFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeLoadingService service = new EmployeeLoadingService();
        int id = Integer.parseInt(request.getParameter("id"));

        Employee refEmp = service.getEmp(id);
       double advance  =service.getAdvance(id);
        int present = service.getPresent(id);
        int half=service.getHalfDAy(id);

        request.setAttribute("empid", refEmp.getEmployeeID());
        request.setAttribute("fname", refEmp.getFname());
        request.setAttribute("lname", refEmp.getLname());
        request.setAttribute("advance",advance);

        //double topay = ( (present*refEmp.getBasicSalary()) + (half*(refEmp.getBasicSalary()/2)) ) - advance;

        //request.setAttribute("topay",topay);

        System.out.println(present);
        System.out.println(half);
        System.out.println(refEmp.getBasicSalary());




        RequestDispatcher dis = request.getRequestDispatcher("paymentForm.jsp");
        dis.forward(request, response);

    }
}
