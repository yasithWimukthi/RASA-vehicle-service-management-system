package com.rasa.servlet;

import com.rasa.model.CarRecords;
import com.rasa.service.CarRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CarRecordUpdateEditServlet")
public class CarRecordUpdateEditServlet extends HttpServlet {

    private CarRecordService CarRec1;

    public void init() {
            this.CarRec1  = new CarRecordService();
        }
       
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int regNumber = Integer.parseInt(request.getParameter("regNumber"));
            CarRecords p =  CarRec1.selectRecord(regNumber);

            request.setAttribute("regNumber",p.getRegNumber());
            request.setAttribute("fname",p.getFname());
            request.setAttribute("lname",p.getLname());
            request.setAttribute("id",p.getId());
            request.setAttribute("address",p.getAddress());
            request.setAttribute("phone",p.getPhone());
            request.setAttribute("email",p.getEmail());
            request.setAttribute("bookNumber",p.getBookNumber());
            request.setAttribute("model",p.getModel());
            request.setAttribute("seatAmount",p.getSeatAmount());
            request.setAttribute("distance",p.getDistance());
            request.setAttribute("carType",p.getCarType());

            request.getRequestDispatcher("CarRecordsEdit.jsp").forward(request,response);

        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
