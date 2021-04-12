package com.rasa.service;

import com.rasa.model.RepairService;
import com.rasa.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
