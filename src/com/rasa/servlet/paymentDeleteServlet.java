package com.rasa.servlet;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import com.rasa.service.paymentService;

@WebServlet("/paymentDeleteServlet")
public class paymentDeleteServlet extends HttpServlet {

    private paymentService sv;

    public paymentDeleteServlet() {
        super();
        sv = new paymentService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int payId= Integer.parseInt(request.getParameter("payId"));



        try {
            sv.deletePayment(payId);
            response.sendRedirect("paymentlist.jsp");
        } catch ( SQLException e) {

            e.printStackTrace();
        }
    }
}
