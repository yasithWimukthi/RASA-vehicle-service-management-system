package com.rasa.service;

import com.rasa.model.Employee;

import java.sql.SQLException;

public interface IEmployee_Details {
    public void addEmployee(Employee employee) throws SQLException, ClassNotFoundException;

    public void EmployeeUpdate(Employee employee)throws SQLException;
    public boolean deleteEmployee(int employee) throws SQLException, ClassNotFoundException;
    public Employee viewEmployeeProfile(int ID);
    public <List> java.util.List<Employee> viewEmployeeDetails() throws SQLException;


    Employee load(String employeeID);
}
