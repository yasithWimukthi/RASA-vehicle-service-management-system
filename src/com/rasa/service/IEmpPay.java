package com.rasa.service;

import com.rasa.model.EmployeePayment;

import java.sql.Date;
import java.util.List;

public interface IEmpPay {
    //payment

    public boolean addPayement(EmployeePayment employeePayment);

    public List<EmployeePayment> showAllPayment();

    public boolean updatePayement(int paymentID,int empID,double bonus, double deduct,double amount);
}

