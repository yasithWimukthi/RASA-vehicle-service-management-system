package com.rasa.service;

import com.rasa.model.Employee;

import java.util.List;

public interface IEmpLoad {
    List<Employee> loadToPaymentTable();

    List<Employee> loadToAttendanceTable();

    Employee getEmp(int id);


    double getAdvance(int id);

    int getPresent(int id);
}
