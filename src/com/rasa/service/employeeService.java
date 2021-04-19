package com.rasa.service;

import com.rasa.model.Employee;
import com.rasa.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class employeeService implements IEmployee_Details{
    private Connection con;
    private PreparedStatement preparedStatement;

    @Override
    public void addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        try {
            con = DBConnectionUtil.getConnection();
           // String sql = EmpQuery.add_emp;
           String sql="INSERT INTO item_db.employee(fname,lname,gender,DOB,NIC,basicSalary,mobile,email,address,joinDate) VALUES (?,?,?,?,?,?,?,?,?,?)";
           preparedStatement=con.prepareStatement(sql);

           preparedStatement.setString(1,employee.getFname());
           preparedStatement.setString(2,employee.getLname());
           preparedStatement.setString(3,employee.getGender());
           preparedStatement.setString(4,employee.getDOB());
           preparedStatement.setString(5,employee.getNIC());
            preparedStatement.setString(6,employee.getBasicSalary());
            preparedStatement.setString(7,employee.getMobile());
            preparedStatement.setString(8,employee.getEmail());
           preparedStatement.setString(9,employee.getAddress());
           preparedStatement.setString(10,employee.getJoinDate());

           preparedStatement.execute();
            System.out.println("Data Insert Successfully");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(Employee employee) {

    }

    @Override
    public Employee viewEmployeeProfile() {
        try{
            con = com.rasa.util.DBConnectionUtil.getConnection();
            String sql ="select employeeID,fname from  item_db.employee";
            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String employeeID=resultSet.getString("employeeID");
                String fname=resultSet.getString("fname");

            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Employee> viewEmployeeDetails()throws SQLException {
        List<Employee> list = new ArrayList<>();
        try{
            con = com.rasa.util.DBConnectionUtil.getConnection();
            String sql ="select employeeID,fname from  item_db.employee";
            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String employeeID=resultSet.getString("employeeID");
                String fname=resultSet.getString("fname");

                Employee employee = new Employee(employeeID,fname);
                list.add(employee);
            }
        }catch(ClassNotFoundException e){
                e.printStackTrace();
        }

        return list;
    }
}
