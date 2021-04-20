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

@WebServlet("/SaveItemservlet")
public class SaveItemservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ItemName = request.getParameter("itemName");
        String SupplerName = request.getParameter("supplerName");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String date = request.getParameter("date");

        Item item = new Item(ItemName ,price,quantity,SupplerName,date);
        //add new Items and suppliers
        Iinventory iinventory = new InventoryService();
        try {
           Boolean IsAdded =  iinventory.AddItem(item);

           if(!IsAdded){
               request.getRequestDispatcher("ItemList.jsp").forward(request,response);
           }
           else{
               request.setAttribute("error","Already Added !");
               request.getRequestDispatcher("addItem.jsp").forward(request,response);

           }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("success");
    }
}
