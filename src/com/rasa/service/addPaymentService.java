package com.rasa.service;

import com.rasa.model.addpayment;
import com.rasa.util.DBConnectionUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class addPaymentService {
    static Connection con;

    public double CalcTotalEstimates(String type , int serviceID) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        double Totalestimate = 0.0;
        double Eamount = 0.0;

        String query = "SELECT vi.estimateAmount FROM  rasa.workprogress w , rasa.repair_service rs , rasa.vehiclerepair_item vi WHERE  w.pid = rs.pid AND rs.ser_id = vi.ser_id AND w.serviceID = ? AND rs.ser_type =?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1,serviceID);
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
}
