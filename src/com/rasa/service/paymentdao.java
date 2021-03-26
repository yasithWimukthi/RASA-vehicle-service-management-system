package com.rasa.service;

import com.rasa.model.paymentList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class paymentdao {


    public paymentdao() {

    }

    // method for insert payments
    public void addPayment(paymentList paymentlist) throws SQLException {


    }


    //method for select payment

    public paymentList selectPayment(String payId) {

        return null;
    }


    //method for select and view payments

    public List<paymentList> selectAllPayments() {

        List<paymentList> pay = new ArrayList<>();


        return pay;
    }

    //method for delete the payment

    public boolean deletePayment(String payId) throws SQLException {
        boolean rowDeleted = false;

        return rowDeleted;
    }


    //method for update payment

    public boolean updatePayment(paymentList paymentlist) throws SQLException {
        boolean rowUpdated = false;
        return rowUpdated;
    }


}







