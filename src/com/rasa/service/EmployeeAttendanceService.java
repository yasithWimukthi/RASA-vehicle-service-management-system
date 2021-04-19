package com.rasa.service;

import com.rasa.model.EmployeeAdvance;
import com.rasa.model.EmployeeAttendance;
import com.rasa.util.DBConnectionUtil;
import com.rasa.util.EmpQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAttendanceService implements IEmpAttendance{
    private Connection con ;
    private  PreparedStatement preparedStatement;

    @Override
    public boolean addAttendance(EmployeeAttendance employeeAttendance) {
        try{
            con = DBConnectionUtil.getConnection();
            String sql= EmpQuery.add_att;
            preparedStatement=con.prepareStatement(sql);

            preparedStatement.setInt(1,employeeAttendance.getEmpID());
            preparedStatement.setInt(2,employeeAttendance.getAdminID());
            preparedStatement.setDate(3,employeeAttendance.getDate());
            preparedStatement.setString(4,employeeAttendance.getStatus());

            preparedStatement.execute();
            System.out.println(preparedStatement);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }
        finally {
            DBConnectionUtil.closeConnection(preparedStatement,con);
        }

        return true;
    }

    @Override
    public boolean updateAttendance(EmployeeAttendance employeeAttendance) {
        return false;
    }

    @Override
    public List<EmployeeAttendance> showAttendance() {

        List <EmployeeAttendance> list = new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql=EmpQuery.all_att;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                int empID = Integer.parseInt(rs.getString(1));
                int adminID = Integer.parseInt(rs.getString(2));
                Date date=Date.valueOf(rs.getString(3));
                String status=(rs.getString(4));

                EmployeeAttendance attendance =new EmployeeAttendance(  );
                attendance.setEmpID(empID);
                attendance.setAdminID(adminID);
                attendance.setDate(date);
                attendance.setStatus(status);

                list.add(attendance);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;

    }

}