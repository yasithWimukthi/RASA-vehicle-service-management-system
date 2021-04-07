package com.rasa.service;

import java.sql.Date;

public interface IEmpAttendance {

    public boolean addAttendance(int empID, int adminID, Date date, String status);

    public boolean updateAttendance(int empID, int adminID, Date date, String status);

    public boolean showAttendance();

}

