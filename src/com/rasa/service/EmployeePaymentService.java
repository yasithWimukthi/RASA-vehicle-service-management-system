package com.rasa.service;

import com.rasa.model.EmployeeAdvance;
import com.rasa.model.EmployeePayment;
import com.rasa.util.DBConnectionUtil;
import com.rasa.util.EmpQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeePaymentService implements IEmpPay {

    private static Connection con;
    private PreparedStatement preparedStatement;

    @Override
    public boolean addPayement(EmployeePayment employeePayment) {
        try{
            con = DBConnectionUtil.getConnection();
            String sql= EmpQuery.add_sal;
            preparedStatement=con.prepareStatement(sql);

            preparedStatement.setInt(1,employeePayment.getEmpID());
            preparedStatement.setInt(2,employeePayment.getAdminID());
            preparedStatement.setDate(3,employeePayment.getDate());
            preparedStatement.setDouble(4,employeePayment.getBonus());
            preparedStatement.setDouble(5,employeePayment.getDeduct());
            preparedStatement.setDouble(6,employeePayment.getAmount());

            preparedStatement.execute();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return false;
        }
        finally {
            DBConnectionUtil.closeConnection(preparedStatement,con);
        }
        return true;
    }

    @Override
    public List<EmployeePayment> showAllPayment() {

        List <EmployeePayment> list = new ArrayList<>();
 
        try {

            con = DBConnectionUtil.getConnection();
            String sql=EmpQuery.all_sal;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                int empID = Integer.parseInt(rs.getString(1));
                int adminID = Integer.parseInt(rs.getString(2));
                Date date=Date.valueOf(rs.getString(3));
                double bonus=Double.parseDouble(rs.getString(4));
                double deduct=Double.parseDouble(rs.getString(5));
                double amount=Double.parseDouble(rs.getString(6));


                list.add(new EmployeePayment(empID,adminID,date,bonus,deduct,amount));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public boolean updatePayement(int paymentID, int empID, double bonus, double deduct, double amount) {
        return false;
    }
}
