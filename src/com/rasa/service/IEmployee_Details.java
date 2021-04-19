package com.rasa.service;

import com.rasa.model.Employee;

import java.sql.SQLException;

public interface IEmployee_Details {
    public void addEmployee(Employee employee) throws SQLException, ClassNotFoundException;
    public void updateEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
    public Employee viewEmployeeProfile();
    public <List> java.util.List<Employee> viewEmployeeDetails() throws SQLException;



}
