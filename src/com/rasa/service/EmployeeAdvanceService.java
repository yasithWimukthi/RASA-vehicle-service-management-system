package com.rasa.service;


import com.rasa.model.EmployeeAdvance;
import com.rasa.util.DBConnectionUtil;
import com.rasa.util.EmpQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAdvanceService implements IEmpAdv {

    private  Connection con;
    private PreparedStatement preparedStatement;

    public boolean addAdvance(EmployeeAdvance advance) {

        try{
            con = DBConnectionUtil.getConnection();
            String sql= EmpQuery.add_adv;
            preparedStatement=con.prepareStatement(sql);

            preparedStatement.setInt(1,advance.getEmpID());
            preparedStatement.setInt(2,advance.getAdminID());
            preparedStatement.setDate(3,advance.getDate());
            preparedStatement.setDouble(2,advance.getAmount());

            preparedStatement.execute();
            System.out.println(preparedStatement);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }
        finally {
            DBConnectionUtil.closeConnection(preparedStatement,con);
        }

       return true;

    }




    public boolean updateAdvance(int advanceID, int empID, double amount) {
        try{
            con = DBConnectionUtil.getConnection();
            String sql= EmpQuery.update_adv;
            preparedStatement=con.prepareStatement(sql);

            preparedStatement.setInt(1,empID);
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





    public EmployeeAdvance showLatestAdvance() {

        EmployeeAdvance employeeAdvance = new EmployeeAdvance();

        try {

            con = DBConnectionUtil.getConnection();
            String sql=EmpQuery.show_adv;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                employeeAdvance.setEmpID(Integer.parseInt(rs.getString("empID")));
                employeeAdvance.setAmount(rs.getDouble("amount"));



            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employeeAdvance;

    }

    public List<EmployeeAdvance> showAllAdvance() {

        List <EmployeeAdvance> list = new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql=EmpQuery.all_adv;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                int empID = Integer.parseInt(rs.getString(1));
                int adminID = Integer.parseInt(rs.getString(2));
                Date date=Date.valueOf(rs.getString(3));
                double amount=Double.parseDouble(rs.getString(4));


                list.add(new EmployeeAdvance(empID,adminID,date,amount));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;

    }




}
