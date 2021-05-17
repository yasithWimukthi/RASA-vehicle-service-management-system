package com.rasa.service;

import com.rasa.model.paymentList;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface ipayment {

    public void addPayment(paymentList paymentlist) throws SQLException;

    public paymentList selectPayment(int payId);

    public List<paymentList> selectAllPayment();

    public boolean deletePayment(int payId) throws SQLException;

    public boolean updatePayment(paymentList paymentlist) throws SQLException;
    public paymentList showLatestPayment();

}