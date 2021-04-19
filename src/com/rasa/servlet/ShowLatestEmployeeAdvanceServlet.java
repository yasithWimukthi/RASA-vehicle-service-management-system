package com.rasa.servlet;

import com.rasa.model.EmployeeAdvance;
import com.rasa.service.EmployeeAdvanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ShowLatestEmployeeAdvanceServlet")
public class ShowLatestEmployeeAdvanceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           // int advanceID = Integer.parseInt(request.getParameter("advanceID"));
        try{
            EmployeeAdvanceService load = new EmployeeAdvanceService();
            EmployeeAdvance advance = load.showLatestAdvance();


            request.setAttribute("empID",advance.getEmpID());
            request.setAttribute("amount",advance.getAmount());


            request.getRequestDispatcher("employeePayment.jsp").forward(request,response);



        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

