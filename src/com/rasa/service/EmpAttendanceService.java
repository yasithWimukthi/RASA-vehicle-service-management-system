package com.rasa.service;

import com.rasa.util.DBConnectionUtil;
import com.rasa.util.EmpQuery;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpAttendanceService {

    private static Connection con;
    private PreparedStatement preparedStatement;


    public boolean addAttendance(int empID, int adminID, Date date, String status) {
        try{
            con = DBConnectionUtil.getConnection();
            String sql= EmpQuery.add_att;
            preparedStatement=con.prepareStatement(sql);

            preparedStatement.setInt(1,empID);
            preparedStatement.setInt(2,adminID);
            preparedStatement.setDate(3,date);
            preparedStatement.setString(4,status);

            preparedStatement.execute();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return false;
        }
        finally {
            DBConnectionUtil.closeConnection(preparedStatement,con);
        }
        return true;
    }


    public boolean updateAttendance(int empID, int adminID, Date date, String status) {
        return false;
    }


    public boolean showAttendance() {
        try {
            con = DBConnectionUtil.getConnection();
            String sql = EmpQuery.all_att;
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.execute();

        } catch (SQLException throwables) {

            throwables.printStackTrace();
            return false;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            DBConnectionUtil.closeConnection(preparedStatement,con);
        }
        return true;
    }
}
