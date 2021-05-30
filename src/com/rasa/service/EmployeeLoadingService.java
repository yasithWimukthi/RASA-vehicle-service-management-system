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

public class EmployeeLoadingService  {

    private static Connection con;
    private PreparedStatement preparedStatement;
    private PreparedStatement preparedStatement1;


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
    

    public Employee getEmp(int id){
        Employee emp  = new Employee(); 
        try {
            con = DBConnectionUtil.getConnection();
            String sql="select * from employee where employeeID="+id;
            preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

           
            
            while(rs.next()){
               int empID = rs.getInt(1);
               String fname=rs.getString(2);
               String lname = rs.getString(3);
               Double bSal=(rs.getDouble(9));


                
                emp.setEmployeeID(empID);
                emp.setFname(fname);
                emp.setLname(lname);
                emp.setBasicSalary(bSal);


            }
            
           
        }catch(Exception e){
            
            e.printStackTrace();
        }
        
        return emp;
    }
    
    

    public double getAdvance(int id){

        double adv = 0;
        try {
            con = DBConnectionUtil.getConnection();
            String sql = "select * from advance where EXTRACT(month from adv_date)=EXTRACT(month from CURRENT_TIMESTAMP) and employeeID="+id;
            preparedStatement = con.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                adv = adv+rs.getDouble(4);

            }
           
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return adv;
    }


    public int getPresent(int id){

        int present =0;
        try{

            con = DBConnectionUtil.getConnection();
            String sql = "select * from attendance where employeeID="+id+" and status='present' and EXTRACT(month from att_date)=EXTRACT(month from CURRENT_TIMESTAMP)";
            preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){

                present++;

            }




        }catch (Exception e){
            e.printStackTrace();
        }

        return present;
    }

    public int getHalfDAy(int id){
        int half=0;
        try{

            con = DBConnectionUtil.getConnection();
            String sql = "select * from attendance where employeeID="+id+" and status='halfday' and EXTRACT(month from att_date)=EXTRACT(month from CURRENT_TIMESTAMP)";
            preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){

                half++;

            }



        }catch (Exception e){
            e.printStackTrace();
        }

        return half;
    }


}