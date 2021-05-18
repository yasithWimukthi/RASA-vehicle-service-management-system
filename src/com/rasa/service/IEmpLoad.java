package com.rasa.service;

import com.rasa.model.Employee;

import java.util.List;

public interface IEmpLoad {
    List<Employee> loadToPaymentTable();

    List<Employee> loadToAttendanceTable();
}
