package com.rasa.service;


import com.rasa.model.addpayment;
import com.rasa.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class addPaymentService {
    static Connection con;

    public double CalcTotalEstimates(String type , int sid) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        double Totalestimate = 0.0;
        double Eamount = 0.0;

        totEstimates(sid);

        String query = "SELECT vi.estimateAmount FROM  rasa.workprogress w , rasa.repair_service rs , rasa.vehiclerepair_item vi WHERE  w.pid = rs.pid AND rs.ser_id = vi.ser_id AND w.sid= ? AND rs.ser_type =?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1,sid);
        preparedStatement.setString(2,type);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Eamount= resultSet.getDouble(1);
            Totalestimate = Totalestimate +Eamount;
        }
        System.out.println(Totalestimate);
        System.out.println(preparedStatement);
        return Totalestimate;

    }

    public double totEstimates(int sid) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        double totalAmount =0.0;
        addpayment addpay = null;
        String query = "SELECT totalAmount FROM  rasa.workprogress WHERE sid = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1,sid);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            totalAmount = resultSet.getDouble("totalAmount");

            addpay = new addpayment(totalAmount);
        }



        System.out.println(preparedStatement);
        return totalAmount;
    }
}
