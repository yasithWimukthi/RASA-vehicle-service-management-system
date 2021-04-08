package com.rasa.service;

import com.rasa.model.RepairService;

import java.sql.SQLException;

public interface Iworkprogress_service {
   public String getProgressId(int sid) throws SQLException, ClassNotFoundException;
   public String createProgressId(int sid);
   public void InsertService(RepairService repairService);


}
