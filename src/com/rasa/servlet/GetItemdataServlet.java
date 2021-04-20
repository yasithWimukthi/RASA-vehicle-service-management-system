package com.rasa.servlet;

import com.rasa.model.Item;
import com.rasa.service.Iinventory;
import com.rasa.service.InventoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/GetItemdataServlet")
public class GetItemdataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ItemCode = request.getParameter("Icode");
        String sname = request.getParameter("sname");
        String date  = request.getParameter("date");

        Iinventory iinventory = new InventoryService();
        try {
            //retrive update object from service(return unique raw)
           Item item =  iinventory.getItemfromId(ItemCode,date,sname);
           request.setAttribute("Oitem" ,item);
           request.getRequestDispatcher("updateItem.jsp").forward(request,response);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
