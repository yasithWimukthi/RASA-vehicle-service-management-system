package com.rasa.service;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rasa.model.CarRecords;
import com.rasa.util.DBConnectionUtil;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//Retrieve car details

public class CarRecordService {

    private static Connection conn;
    private static PreparedStatement preparedStatement;

    public static List<CarRecords> CarRecordRetrieve() {
        ArrayList<CarRecords> CR = new ArrayList<>();

        try {

            conn = DBConnectionUtil.getConnection();
            String sql = "select * from carregisterdetails";
            preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int regNumber = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                String id = rs.getString(4);
                String address = rs.getString(5);
                int phone = rs.getInt(6);
                String email = rs.getString(7);
                String bookNumber = rs.getString(8);
                String model = rs.getString(9);
                int seatAmount = rs.getInt(10);
                float distance = rs.getFloat(11);
                String carType = rs.getString(12);

                CarRecords CarRec = new CarRecords(regNumber, fname, lname,id,address, phone, email, bookNumber, model, seatAmount, distance, carType);

                CR.add(CarRec);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return CR;
    }

    //insert car Records

    public static void insertCarRecords(CarRecords carRecords) {


        try {

            conn = DBConnectionUtil.getConnection();
            String sql = " INSERT INTO carregisterdetails  (fname,lname,id,address,phone,email,bookNumber,model,seatAmount,distance,carType) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            preparedStatement = conn.prepareStatement(sql);


            preparedStatement.setString(1, carRecords.getFname());
            preparedStatement.setString(2, carRecords.getLname());
            preparedStatement.setString(3, carRecords.getId());
            preparedStatement.setString(4, carRecords.getAddress());
            preparedStatement.setInt(5, carRecords.getPhone());
            preparedStatement.setString(6, carRecords.getEmail());
            preparedStatement.setString(7, carRecords.getBookNumber());
            preparedStatement.setString(8, carRecords.getModel());
            preparedStatement.setInt(9, carRecords.getSeatAmount());
            preparedStatement.setFloat(10, carRecords.getDistance());
            preparedStatement.setString(11, carRecords.getCarType());

            preparedStatement.executeLargeUpdate();
            System.out.println(preparedStatement);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //update CarDetails

    public static boolean UpdateCarRecords(CarRecords carrecords) throws SQLException {
        boolean rowUpdated = false;
        try {

            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE carregisterdetails set fname = ?,lname = ?,id = ?,address = ?,phone = ?,email = ?,bookNumber = ?,model = ?,seatAmount = ?,distance = ?,carType = ? where regNumber = ?");

            statement.setString(1, carrecords.getFname());
            statement.setString(2, carrecords.getLname());
            statement.setString(3, carrecords.getID());
            statement.setString(4, carrecords.getAddress());
            statement.setInt(5, carrecords.getPhone());
            statement.setString(6, carrecords.getEmail());
            statement.setString(7, carrecords.getBookNumber());
            statement.setString(8, carrecords.getModel());
            statement.setInt(9, carrecords.getSeatAmount());
            statement.setFloat(10, carrecords.getDistance());
            statement.setString(11, carrecords.getCarType());
            statement.setInt(12, carrecords.getRegNumber());

            System.out.println(statement);


            rowUpdated = statement.executeUpdate() > 0;//return number of rows updated
        } catch (SQLException | ClassNotFoundException e) {
            printSQLException((SQLException) e);
        }
        return rowUpdated;
    }

    private static void printSQLException(SQLException e) {
    }

    //select to update carDetails

    public CarRecords selectRecord(int regNumber) {
        CarRecords carRecords = null;

        try {
            conn = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT regNumber,fname,lname,id,address,phone,email,bookNumber,model,seatAmount,distance,carType FROM carregisterdetails WHERE regNumber = ?");
            preparedStatement.setInt(1, regNumber);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String id = rs.getString("id");
                String address = rs.getString("address");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String bookNumber = rs.getString("bookNumber");
                String model = rs.getString("model");
                int seatAmount = rs.getInt("seatAmount");
                float distance = rs.getFloat("distance");
                String carType = rs.getString("carType");

                carRecords = new CarRecords(regNumber, fname, lname, id, address, phone, email, bookNumber, model, seatAmount, distance, carType);

            }
            System.out.println(preparedStatement);

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return carRecords;

    }


    //delete car details

    public boolean DeleteCarRecords(int regNumber) throws SQLException {
        CarRecords carRecords = null;
        boolean rowDeleted = false;
        try {

            conn = DBConnectionUtil.getConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM carregisterdetails WHERE regNumber = ?");
            System.out.println(statement);

            statement.setInt(1, regNumber);

            // update query
            rowDeleted = statement.executeUpdate() > 0;//return number of rows deleted
        } catch (SQLException | ClassNotFoundException e) {
            printSQLException((SQLException) e);
        }
        return rowDeleted;

    }

    //Report Genarate

    public static void ReportGenarate()throws IOException, DocumentException {

        List<CarRecords> list = new ArrayList<>();
        list = CarRecordService.CarRecordRetrieve();

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("E:/CarRecords.pdf"));
        document.open();
        PdfPTable table = new PdfPTable(6);

        PdfPCell cell1 = new PdfPCell(new Paragraph("regNumber"));
        PdfPCell cell2 = new PdfPCell(new Paragraph("fname"));
        PdfPCell cell3 = new PdfPCell(new Paragraph("lname"));
        PdfPCell cell4 = new PdfPCell(new Paragraph("id"));
        PdfPCell cell5 = new PdfPCell(new Paragraph("phone"));
        PdfPCell cell6 = new PdfPCell(new Paragraph("email"));
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        table.addCell(cell5);
        table.addCell(cell6);
        for (CarRecords pay : list) {

            PdfPCell cell7 = new PdfPCell(new Paragraph(String.valueOf(pay.getRegNumber())));
            PdfPCell cell8 = new PdfPCell(new Paragraph(pay.getFname()));
            PdfPCell cell9 = new PdfPCell(new Paragraph(pay.getLname()));
            PdfPCell cell10 = new PdfPCell(new Paragraph(pay.getId()));
            PdfPCell cell11 = new PdfPCell(new Paragraph(String.valueOf(pay.getPhone())));
            PdfPCell cell12 = new PdfPCell(new Paragraph(pay.getEmail()));


            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);
        }
        document.add(table);
        document.close();

    }
}
