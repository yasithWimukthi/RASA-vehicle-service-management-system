package com.rasa.service;

import com.rasa.model.EmployeeAdvance;

import java.sql.Date;
import java.util.List;

public interface IEmpAdv {

    //advance
    public boolean addAdvance(EmployeeAdvance employeeAdvance);

    public boolean updateAdvance(int advanceID, int empID, double amount);

    public boolean deleteAdvance(int advanceID);

    public EmployeeAdvance showLatestAdvance();

    public List<EmployeeAdvance> showAllAdvance();

}
