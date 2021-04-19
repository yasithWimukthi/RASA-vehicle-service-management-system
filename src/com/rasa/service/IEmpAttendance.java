package com.rasa.service;

import com.rasa.model.EmployeeAttendance;

import java.sql.Date;
import java.util.List;

public interface IEmpAttendance {

    public boolean addAttendance(EmployeeAttendance employeeAttendance);

    public boolean updateAttendance(EmployeeAttendance employeeAttendance);

    public List<EmployeeAttendance> showAttendance();

}

