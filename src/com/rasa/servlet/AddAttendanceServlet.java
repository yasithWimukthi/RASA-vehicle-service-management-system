package com.rasa.servlet;

import com.rasa.model.EmployeeAttendance;
import com.rasa.service.EmployeeAdvanceService;
import com.rasa.service.EmployeeAttendanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddAttendanceServlet")
public class AddAttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empId = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("att");
        System.out.println(status);

        EmployeeAttendance att = new EmployeeAttendance();
        att.setEmpID(empId);
        att.setStatus(status);

        EmployeeAttendanceService service = new EmployeeAttendanceService();
        service.addAttendance(att);

        response.sendRedirect("attendance.jsp");


    }
}