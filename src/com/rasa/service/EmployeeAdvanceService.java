package com.rasa.service;


import com.rasa.model.EmployeeAdvance;
import com.rasa.util.DBConnectionUtil;
import com.rasa.util.EmpQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAdvanceService  implements IEmpAdv{

    private   Connection con;
    private PreparedStatement preparedStatement;

    public boolean addAdvance(EmployeeAdvance advance) {

        try{
            con = DBConnectionUtil.getConnection();
            String sql= EmpQuery.add_adv;
            preparedStatement=con.prepareStatement(sql);

            preparedStatement.setInt(1,advance.getEmpID());
          //  preparedStatement.setInt(2,advance.getAdminID());
           // preparedStatement.setDate(3,advance.getDate());
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




    public boolean updateAdvance(EmployeeAdvance employeeAdvance) {
        boolean rowUpdated = false;
        try {


            con = DBConnectionUtil.getConnection();
            String sql = EmpQuery.update_adv;
            PreparedStatement statement = con.prepareStatement(sql);

            preparedStatement.setInt(1, employeeAdvance.getEmpID());
            preparedStatement.setDouble(2,employeeAdvance.getAmount());

           System.out.println(preparedStatement);
            rowUpdated = statement.executeUpdate() > 0;//return number of rows updated
        }catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
        }
        return rowUpdated;
    }


    public boolean deleteAdvance() {
        EmployeeAdvance employeeAdvance=null;
        boolean rowDeleted = false;
        try {

            con = DBConnectionUtil.getConnection();
            String sql=EmpQuery.del_adv;
            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);


            //use to update the query
            rowDeleted = preparedStatement.executeUpdate() > 0;//return number of rows deleted
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowDeleted;
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
                int empID = rs.getInt("empID");
                double amount = rs.getDouble("amount");


                employeeAdvance = new EmployeeAdvance();
                employeeAdvance.setEmpID(empID);
                employeeAdvance.setAmount(amount);
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
               // int adminID = Integer.parseInt(rs.getString(2));
               // Date date=Date.valueOf(rs.getString(3));
                double amount=Double.parseDouble(rs.getString(2));

                EmployeeAdvance advance =new EmployeeAdvance();
                advance.setEmpID(empID);
               // advance.setDate(date);
                advance.setAmount(amount);

                list.add(advance);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;

    }



}
