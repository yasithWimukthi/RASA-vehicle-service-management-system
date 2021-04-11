package com.rasa.service;


import com.rasa.util.DBConnectionUtil;
import com.rasa.util.EmpQuery;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeAdvanceService implements IEmpAdv {

    private static Connection con;
    private PreparedStatement preparedStatement;

    @Override
    public boolean addAdvance(int empID, int adminID, Date date, double amount) {

        try{
            con = DBConnectionUtil.getConnection();
            String sql= EmpQuery.add_adv;
            preparedStatement=con.prepareStatement(sql);

            preparedStatement.setInt(1,empID);
            preparedStatement.setInt(2,adminID);
            preparedStatement.setDate(3,date);
            preparedStatement.setDouble(4,amount);

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
    public boolean updateAdvance(int advanceID, int empID, double amount) {
        return false;
    }

    @Override
    public boolean deleteAdvance(int advanceID) {
        try{
            con = DBConnectionUtil.getConnection();
            String sql = EmpQuery.del_adv;
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1,advanceID);

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
    public boolean showLatestAdvance() {
        try {
            con = DBConnectionUtil.getConnection();
            String sql = EmpQuery.show_adv;
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
    public boolean showAllAdvance() {

        try {
            con = DBConnectionUtil.getConnection();
            String sql = EmpQuery.all_adv;
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
}
