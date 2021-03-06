package com.rasa.service;

import com.itextpdf.text.DocumentException;
import com.rasa.model.RepairComponent;
import com.rasa.model.RepairService;
import com.rasa.model.VehicleComponent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Iworkprogress_service {
   //Generate Id
   public String getProgressId(int sid) throws SQLException, ClassNotFoundException;
   public String createProgressId(int sid);
   public String createServiceId(String pid,String type);
   //work service
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
   public Boolean deleteRepairComponent(String ser_id , String item_id) throws SQLException, ClassNotFoundException;


   //calculation
   public double CalcTotalEstimates(String type , int sid) throws SQLException, ClassNotFoundException;

   //pdf generator
   public boolean createEstimatePdf(ArrayList<RepairService> repairServices) throws IOException, DocumentException, SQLException, ClassNotFoundException;



}
