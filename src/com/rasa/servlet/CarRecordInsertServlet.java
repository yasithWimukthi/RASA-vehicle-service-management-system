package com.rasa.servlet;
import com.rasa.model.CarRecords;
import com.rasa.service.CarRecordService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CarRecordInsertServlet")
public class CarRecordInsertServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String id = request.getParameter("id");
        String address = request.getParameter("address");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email = request.getParameter("email");
        String bookNumber = request.getParameter("bookNumber");
        String model = request.getParameter("model");
        int seatAmount = Integer.parseInt(request.getParameter("seatAmount"));
        float distance = Float.parseFloat(request.getParameter("distance"));
        String carType = request.getParameter("carType");


        CarRecords newRecord = new CarRecords(fname,lname,id,address,phone,email,bookNumber,model,seatAmount,distance,carType);

            try{

                CarRecordService.insertCarRecords(newRecord);
                RequestDispatcher dis = request.getRequestDispatcher("CRecords.jsp");
                dis.forward(request,response);

            }catch(Exception e) {
                e.printStackTrace();
            }
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
