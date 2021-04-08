package com.rasa.service;

import com.rasa.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Workprogress_service implements Iworkprogress_service{


    @Override
    public String getProgressId(int sid) throws SQLException, ClassNotFoundException {
        //initialized pid
        String pid = null;
        Connection con = DBConnectionUtil.getConnection();
        String sql = "Select pid from workprogress where sid = ? ";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,sid);

        ResultSet S_pid = preparedStatement.executeQuery();
        while(S_pid.next()){
            pid = S_pid.getString(1);

        }

        return pid;
    }
}
