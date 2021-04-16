package com.rasa.service;

import com.rasa.model.RepairComponent;
import com.rasa.model.RepairService;
import com.rasa.model.VehicleComponent;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Iworkprogress_service {
   //repair service
   public String getProgressId(int sid) throws SQLException, ClassNotFoundException;
   public String createProgressId(int sid);
   public String createServiceId(String pid,String type);
   public boolean Createprogress(int sid) throws SQLException, ClassNotFoundException;
   public Boolean InsertService(RepairService repairService) throws SQLException, ClassNotFoundException;
   public ArrayList<RepairService> displayServicelist(String pid) throws SQLException, ClassNotFoundException;
   public RepairService retirvedatabyID(String ser_id) throws SQLException, ClassNotFoundException;
   public boolean updateServiceStatus(RepairService repairService) throws SQLException, ClassNotFoundException;
   //repair component
   public Boolean addRepairComponent(RepairComponent repairComponent) throws SQLException, ClassNotFoundException;
   public ArrayList<RepairComponent> retriveRepairComponents(String ser_id) throws SQLException, ClassNotFoundException;
   public ArrayList<VehicleComponent> retriveVehcileComponents() throws SQLException, ClassNotFoundException;
   public RepairComponent retriveRepairComponentById(String ser_id,String Item_id,String s_name) throws SQLException, ClassNotFoundException;
   public Boolean UpdateRepairComponent(String ser_id , String item_id , int estimateA) throws SQLException, ClassNotFoundException;


   //backend validation

}
