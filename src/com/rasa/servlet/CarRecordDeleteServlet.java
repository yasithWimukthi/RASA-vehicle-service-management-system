package com.rasa.servlet;

import com.rasa.service.CarRecordService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CarRecordDeleteServlet")
public class CarRecordDeleteServlet extends HttpServlet {

        private CarRecordService carRecordService;
        public CarRecordDeleteServlet() {
            super();
            carRecordService = new CarRecordService();
        }

            protected void doGet (HttpServletRequest request, HttpServletResponse response)throws IOException {

                int regNumber = Integer.parseInt(request.getParameter("regNumber"));
                try {
                    carRecordService.DeleteCarRecords(regNumber);
                    response.sendRedirect("CRecords.jsp");
                } catch (SQLException e) {

                    e.printStackTrace();
                }

            }

            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

            }
        }
        