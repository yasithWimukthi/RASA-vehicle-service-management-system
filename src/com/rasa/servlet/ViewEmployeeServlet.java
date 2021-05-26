package com.rasa.servlet;

import com.rasa.model.Employee;
import com.rasa.service.employeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/viewEmployeeServlet")
public class ViewEmployeeServlet extends HttpServlet {
    employeeService employeeService;
    public void init(){
        this.employeeService=new employeeService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> list = new ArrayList<>();

        try{
            list=employeeService.viewEmployeeDetails();
            req.setAttribute("list",list);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
