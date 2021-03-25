package com.rasa.service;

import java.sql.Date;

public interface IEmpPay {
    //payment

    public boolean addPayement(int empID, int adminID, Date date, double bonus, double deduct, double amount);

    public boolean showPayement(int paymentID,int empID, int adminID, Date date,double bonus, double deduct,double amount);

    public boolean upodatePayement(int paymentID,int empID,double bonus, double deduct,double amount);
}

