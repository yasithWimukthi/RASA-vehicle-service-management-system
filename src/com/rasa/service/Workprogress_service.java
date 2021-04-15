package com.rasa.service;

import com.rasa.model.RepairComponent;
import com.rasa.model.RepairService;
import com.rasa.model.VehicleComponent;
import com.rasa.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Workprogress_service implements Iworkprogress_service{

    Connection con = null;
    @Override
    public String getProgressId(int sid) throws SQLException, ClassNotFoundException {
        //initialized pid
        String pid = null;
        con = DBConnectionUtil.getConnection();
        String sql = "Select pid from workprogress where sid = ? ";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,sid);

        ResultSet S_pid = preparedStatement.executeQuery();
        while(S_pid.next()){
            pid = S_pid.getString(1);

        }
        return pid;
    }

    @Override
    public String createProgressId(int sid) {
        return "PID"+sid;
    }

    @Override
    public String createServiceId(String pid,String type) {
        return pid + type.substring(1,4);
    }

    @Override
    public boolean Createprogress(int sid) throws SQLException, ClassNotFoundException {
        String pid = this.createProgressId(sid);
        //if user refresh page twice page will redirect to the add_service.jsp
        if(getProgressId(sid) != null){
            return false;
        }
        //if it was not create pid
        con = DBConnectionUtil.getConnection();
        String sql = "INSERT INTO `workprogress`(`pid`,`sid`) VALUES (?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);

        preparedStatement.setString(1,pid);
        preparedStatement.setInt(2,sid);

        Boolean isCreate = preparedStatement.execute();
        return isCreate;


    }

    //insert function
    @Override
    public Boolean InsertService(RepairService repairService) throws SQLException, ClassNotFoundException {
        //create serviceID and return ID
        String ser_id = this.createServiceId(repairService.getPid(),repairService.getSer_type());
        con = DBConnectionUtil.getConnection();
        String sqlInsert ="INSERT INTO `repair_service`(`ser_id`, `ser_type`, `description`, `status`, `s_date`, `pid`) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sqlInsert);
        preparedStatement.setString(1,ser_id);
        preparedStatement.setString(2,repairService.getSer_type());
        preparedStatement.setString(3,repairService.getDescription());
        preparedStatement.setString(4,repairService.getStatus());
        preparedStatement.setString(5,repairService.getDate());
        preparedStatement.setString(6,repairService.getPid());

        Boolean Is_add = preparedStatement.execute();
        return Is_add;

    }

    @Override
    public ArrayList<RepairService> displayServicelist(String pid) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        ArrayList<RepairService> rList = new ArrayList<>();
        String selecQuery = "SELECT `ser_id`, `ser_type`, `description`, `status`, `s_date` FROM `repair_service` WHERE pid = ?";

        PreparedStatement preparedStatement = con.prepareStatement(selecQuery);
        preparedStatement.setString(1,pid);

        ResultSet listService = preparedStatement.executeQuery();

        while(listService.next()){
            RepairService repairService = new RepairService();
            repairService.setSer_Id(listService.getString(1));
            repairService.setSer_type(listService.getString(2));
            repairService.setDescription(listService.getString(3));
            repairService.setStatus(listService.getString(4));
            repairService.setDate(listService.getString(5));

            rList.add(repairService);

        }
        return rList;
    }

    @Override
    public RepairService retirvedatabyID(String ser_id) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        String getdatabyId = "SELECT `ser_id`, `ser_type`, `description`, `status`, `s_date` FROM `repair_service` WHERE ser_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(getdatabyId);
        preparedStatement.setString(1,ser_id);

        ResultSet ser_recd = preparedStatement.executeQuery();
        RepairService r1 = new RepairService();
        while (ser_recd.next()){
            r1.setSer_Id(ser_recd.getString(1));
            r1.setSer_type(ser_recd.getString(2));
            r1.setDescription(ser_recd.getString(3));
            r1.setStatus(ser_recd.getString(4));
            r1.setDate(ser_recd.getString(5));
        }
        return r1;


    }

    @Override
    public boolean updateServiceStatus(RepairService repairService) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        String updateQuery = "UPDATE `repair_service` SET `description`=? ,`status`= ? WHERE `ser_id` = ?";
        PreparedStatement preparedStatement = con.prepareStatement(updateQuery);
        preparedStatement.setString(1,repairService.getDescription());
        preparedStatement.setString(2,repairService.getStatus());
        preparedStatement.setString(3,repairService.getSer_Id());
        int res = preparedStatement.executeUpdate();
        if(res==1)
            return true;
        else
            return false;

    }

    @Override
    public Boolean addRepairComponent(RepairComponent repairComponent) throws SQLException, ClassNotFoundException {

        con = DBConnectionUtil.getConnection();
        String insertQuery = "INSERT INTO `vehiclerepair_item`(`ser_id`, `ItemId`, `estimateAmount`) VALUES (?,?,?)";

        PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
        preparedStatement.setString(1,repairComponent.getRepairService().getSer_Id());
        preparedStatement.setString(2,repairComponent.getVehicleComponent().getV_itemId());
        preparedStatement.setInt(3,repairComponent.getEstimateAmount());

        Boolean res = preparedStatement.execute();

        return res;
    }

    @Override
    public ArrayList<RepairComponent> retriveRepairComponents(String ser_id) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        ArrayList<RepairComponent> List_repair_com = new ArrayList<>();
        String retrive_comp_query = "SELECT ve.ser_id , ve.ItemId , ve.estimateAmount , r.ItemName FROM vehiclerepair_item ve , repairitem r WHERE r.ItemId = ve.ItemId AND ve.ser_id =?";
        PreparedStatement preparedStatement = con.prepareStatement(retrive_comp_query);

        preparedStatement.setString(1,ser_id);
        ResultSet listRepairC = preparedStatement.executeQuery();

        while(listRepairC.next()){
            RepairComponent repairComponent = new RepairComponent();
            RepairService repairService = new RepairService();
            VehicleComponent vehicleComponent = new VehicleComponent();

            String serId = listRepairC.getString(1);
            String ItemId = listRepairC.getString(2);
            int estimateA = listRepairC.getInt(3);
            String ItemName = listRepairC.getString(4);

            repairService.setSer_Id(serId);
            vehicleComponent.setV_itemId(ItemId);
            vehicleComponent.setV_Item_name(ItemName);

            repairComponent.setRepairService(repairService);
            repairComponent.setVehicleComponent(vehicleComponent);
            repairComponent.setEstimateAmount(estimateA);


            List_repair_com.add(repairComponent);

        }

        return List_repair_com;
    }

    @Override
    public ArrayList<VehicleComponent> retriveVehcileComponents() throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        ArrayList<VehicleComponent> list_Vehicle_Com = new ArrayList<>();
        String getVehcileComQuery = "SELECT `ItemId`, `ItemName` FROM `repairitem`";
        PreparedStatement preparedStatement = con.prepareStatement(getVehcileComQuery);
        ResultSet ListVehicleComponents =  preparedStatement.executeQuery();
        while (ListVehicleComponents.next()){
             VehicleComponent vehicleComponent = new VehicleComponent(
                     ListVehicleComponents.getString(1),
                     ListVehicleComponents.getString(2)
             );
             list_Vehicle_Com.add(vehicleComponent);


        }


        return list_Vehicle_Com;
    }


}
