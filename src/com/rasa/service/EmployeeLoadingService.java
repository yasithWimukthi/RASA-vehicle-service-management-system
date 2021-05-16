package com.rasa.service;


import com.rasa.model.Employee;
import com.rasa.model.EmployeePayment;
import com.rasa.util.DBConnectionUtil;
import com.rasa.util.EmpQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeLoadingService  implements IEmpLoad{

    private static Connection con;
    private PreparedStatement preparedStatement;
    private PreparedStatement preparedStatement1;

    @Override
    public List<Employee> loadToPaymentTable(){

        List<Employee> list =new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql= EmpQuery.to_EmpPay_table;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                int empID = Integer.parseInt(rs.getString(1));
                String fname =(rs.getString(2));
                String lname=(rs.getString(3));

                Employee emp = new Employee();
                emp.setEmployeeID(empID);
                emp.setFname(fname);
                emp.setLname(lname);

                list.add(emp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public List<Employee> loadToAttendanceTable(){

        List<Employee> list =new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql2=EmpQuery.to_EmpAtt_table;
            preparedStatement = con.prepareStatement(sql2);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){

                int empID = Integer.parseInt(rs.getString(1));
                String fname =(rs.getString(2));
                String lname=(rs.getString(3));

                Employee emp = new Employee();
                emp.setEmployeeID(empID);
                emp.setFname(fname);
                emp.setLname(lname);

                list.add(emp);

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;

    }

    public EmployeePayment toPaymentForm(int id){

        return null;
    }


}