package com.rasa.servlet;

import com.itextpdf.text.DocumentException;
import com.rasa.service.paymentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
    paymentService ps;

    public BillServlet(){
        super();
        ps = new paymentService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int payId = Integer.parseInt(request.getParameter("payId"));

        try {
            ps.billGenerate(payId);
            response.sendRedirect("paymentlist.jsp");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
