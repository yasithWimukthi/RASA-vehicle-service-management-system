package com.rasa.service;

import com.rasa.util.DBConnectionUtil;
import com.rasa.util.EmpQuery;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeePaymentService implements IEmpPay {

    private static Connection con;
    private PreparedStatement preparedStatement;

    @Override
    public boolean addPayement(int empID, int adminID, Date date, double bonus, double deduct, double amount) {
        try{
            con = DBConnectionUtil.getConnection();
            String sql= EmpQuery.add_sal;
            preparedStatement=con.prepareStatement(sql);

            preparedStatement.setInt(1,empID);
            preparedStatement.setInt(2,adminID);
            preparedStatement.setDate(3,date);
            preparedStatement.setDouble(4,bonus);
            preparedStatement.setDouble(5,deduct);
            preparedStatement.setDouble(6,amount);

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
    public boolean showPayement(int paymentID, int empID, int adminID, Date date, double bonus, double deduct, double amount) {
        try {
            con = DBConnectionUtil.getConnection();
            String sql = EmpQuery.all_sal;
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.execute();

        } catch (SQLException throwables) {

            throwables.printStackTrace();
            return false;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            DBConnectionUtil.closeConnection(preparedStatement,con);
        }
        return true;

    }

    @Override
    public boolean updatePayement(int paymentID, int empID, double bonus, double deduct, double amount) {
        return false;
    }
}
