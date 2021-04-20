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

@WebServlet("/UpdateItemServlet")
public class UpdateItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String Iname = request.getParameter("itemName");
           int SupId = Integer.parseInt(request.getParameter("supplerName"));
           double price = Double.parseDouble(request.getParameter("price"));
           int qun = Integer.parseInt(request.getParameter("quantity"));
           String date = request.getParameter("date");

           System.out.println(SupId);

           Item item = new Item(Iname, price, qun, date,SupId);

           Iinventory iinventory = new InventoryService();
        try {
            //update Items information(prices and quantity)
            boolean IsUpdated = iinventory.updateItem(item);
            if(IsUpdated){
                request.setAttribute("updated","successfully Updated !");
                request.getRequestDispatcher("ItemList.jsp").forward(request,response);

            }
            else{
               // request.getRequestDispatcher("ItemList.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
