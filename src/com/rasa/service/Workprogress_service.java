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
    public boolean Createprogress(int sid) throws SQLException, ClassNotFoundException {
        String pid = this.createProgressId(sid);

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
    public void InsertService(RepairService repairService) {
        //I have to implement
    }
}
