package com.rasa.service;

import java.sql.Date;

public interface IEmpAdv {

    //advance
    public boolean addAdvance(int empID, int adminID, Date date, double amount);

    public boolean updateAdvance(int advanceID, int empID, double amount);

    public boolean deleteAdvance(int advanceID);

    public boolean showLatestAdvance();

    public boolean showAllAdvance();

}
