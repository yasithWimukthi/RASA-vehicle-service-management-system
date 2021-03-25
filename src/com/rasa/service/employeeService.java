package com.rasa.service;

import com.rasa.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class employeeService {
        private String jdbcURL;
        private String jdbcUsername;
        private String jdbcPassword;
        private Connection jdbcConnection;

        public employeeService(String jdbcURL, String jdbcUsername, String jdbcPassword, Connection jdbcConnection) {
            this.jdbcURL = jdbcURL;
            this.jdbcUsername = jdbcUsername;
            this.jdbcPassword = jdbcPassword;
            this.jdbcConnection = jdbcConnection;
        }

    protected void connect() throws
            SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    public boolean insertEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee (fname, lname, gender,DOB,address,email,mobile,basicSalary,joinDate) VALUES (?, ?, ?,?,?,?,?,?,?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, employee.getFname());
        statement.setString(2, employee.getLname());
        statement.setString(3, employee.getGender());
        statement.setDate(4, employee.getDOB());
        statement.setString(5, employee.getAddress());
        statement.setString(6, employee.getEmail());
        statement.setString(7, employee.getMobile());
        statement.setDouble(8, employee.getBasicSalary());
        statement.setDate(9, employee.getJoinDate());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Employee> viewEmployee() throws SQLException {
        List<Employee> viewEmployee = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String fname = resultSet.getString("fname");
            String lname = resultSet.getString("lname");
            String gender = resultSet.getString("gender");
            double basicSalary = resultSet.getDouble("basicSalary");
            Date DOB = resultSet.getDate("date of birth");
            String address = resultSet.getString("Address");
            String email = resultSet.getString("Email");
            String mobile = resultSet.getString("Mobile");
            Date joinDate = resultSet.getDate("join Date");

            Employee employee = new Employee(fname,lname,gender,basicSalary,DOB,address,email,mobile,joinDate);
            viewEmployee.add(employee);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return viewEmployee;
    }

}
