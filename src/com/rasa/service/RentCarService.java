package com.rasa.service;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rasa.model.AvailableCars;
import com.rasa.model.Rent;
import com.rasa.util.DBConnectionUtil;

//import java.awt.*;
//import java.awt.Font;
//import java.awt.Image;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class RentCarService implements IRentCarService{


    @Override
    public boolean insertRentalDetails(Rent rent) throws SQLException, ClassNotFoundException {

        Connection con = DBConnectionUtil.getConnection();
        String insertQuery = "INSERT INTO `rasa`.`rent` (`firstName`, `lastName`, `email`, `phone`, `address`, `pickUpDate`, `dropOffDate`, `rentalPrice`, `registrationNumber`, `operaterID`) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(insertQuery);

        preparedStatement.setString(1, rent.getFirstName());
        preparedStatement.setString(2, rent.getLastName());
        preparedStatement.setString(3, rent.getEmail());
        preparedStatement.setString(4, rent.getMobile());
        preparedStatement.setString(5, rent.getAddress());
        preparedStatement.setString(6, rent.getPickUpDate());
        preparedStatement.setString(7, rent.getDropOffDate());
        preparedStatement.setDouble(8, rent.getRentalPrice());
        preparedStatement.setInt(9, rent.getRegistrationNo());
        preparedStatement.setInt(10, rent.getOperatorID());

        boolean isSuccess = preparedStatement.execute();

        return isSuccess;

    }

    @Override
    public ArrayList<Rent> retrieveRentalDetails() throws SQLException, ClassNotFoundException {

        Connection con = DBConnectionUtil.getConnection();

        ArrayList<Rent> list = new ArrayList<>();

        String selectQuery = "SELECT `rent`.`rentID`, `rent`.`firstName`, `rent`.`lastName`, `rent`.`email`, `rent`.`phone`, `rent`.`address`, `rent`.`pickUpDate`, `rent`.`dropOffDate`, `rent`.`rentalPrice`, `rent`.`registrationNumber` FROM `rasa`.`rent`;";
        PreparedStatement preparedStatement = con.prepareStatement(selectQuery);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){
            Rent rent = new Rent();

            rent.setRentID(rs.getInt(1));
            rent.setFirstName(rs.getString(2));
            rent.setLastName(rs.getString(3));
            rent.setEmail(rs.getString(4));
            rent.setMobile(rs.getString(5));
            rent.setAddress(rs.getString(6));
            rent.setPickUpDate(rs.getString(7));
            rent.setDropOffDate(rs.getString(8));
            rent.setRentalPrice(rs.getDouble(9));
            rent.setRegistrationNo(rs.getInt(10));

            list.add(rent);

        }
        return list;
    }

    @Override
    public ArrayList<AvailableCars> retrieveAvailableCars() throws SQLException, ClassNotFoundException {

        Connection con = DBConnectionUtil.getConnection();

        ArrayList<AvailableCars> list = new ArrayList<>();

        String selectQuery = "SELECT `rentalvehicle`.`RegistrationNumber`, `rentalvehicle`.`brand`, `rentalvehicle`.`model`, `rentalvehicle`.`NoOfsheets`, `rentalvehicle`.`rentalPrice` FROM `rasa`.`rentalvehicle`;";
        PreparedStatement preparedStatement = con.prepareStatement(selectQuery);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){
            AvailableCars availableCars = new AvailableCars();

            availableCars.setRegistrationNumber(rs.getInt(1));
            availableCars.setBrand(rs.getString(2));
            availableCars.setModel(rs.getString(3));
            availableCars.setNumberOfSeats(rs.getInt(4));
            availableCars.setPricePerDay(rs.getDouble(5));
            //availableCars.setStatus(rs.getString(6));

            list.add(availableCars);

        }

        return list;

    }

    @Override
    public Rent retrieveDataByRentID(int RentID) throws SQLException, ClassNotFoundException {

        Connection con = DBConnectionUtil.getConnection();
        String selectQuery = "SELECT `rent`.`rentID`, `rent`.`firstName`, `rent`.`lastName`, `rent`.`email`, `rent`.`phone`, `rent`.`address`, `rent`.`pickUpDate`, `rent`.`dropOffDate`, `rent`.`rentalPrice`, `rent`.`registrationNumber` FROM `rasa`.`rent` WHERE `rent`.`rentID`=?;";
        PreparedStatement preparedStatement = con.prepareStatement(selectQuery);

        preparedStatement.setInt(1, RentID);
        ResultSet rs = preparedStatement.executeQuery();

        Rent rent = new Rent();

        while(rs.next()){

            rent.setRentID(rs.getInt(1));
            rent.setFirstName(rs.getString(2));
            rent.setLastName(rs.getString(3));
            rent.setEmail(rs.getString(4));
            rent.setMobile(rs.getString(5));
            rent.setAddress(rs.getString(6));
            rent.setPickUpDate(rs.getString(7));
            rent.setDropOffDate(rs.getString(8));
            rent.setRentalPrice(rs.getDouble(9));
            rent.setRegistrationNo(rs.getInt(10));

        }

        return rent;

    }

    @Override
    public boolean updateRentDetails(Rent rent) throws SQLException, ClassNotFoundException {
        Connection con = DBConnectionUtil.getConnection();

        String updateQuery = "UPDATE `rasa`.`rent` SET `rentID` = ?, `firstName` = ?, `lastName` = ?, `email` = ?, `phone` = ?, `address` = ?, `pickUpDate` = ?, `dropOffDate` = ?, `rentalPrice` = ?, `registrationNumber` = ? WHERE `rentID` = ?";
        PreparedStatement preparedStatement = con.prepareStatement(updateQuery);

        preparedStatement.setInt(1, rent.getRentID());
        preparedStatement.setString(2, rent.getFirstName());
        preparedStatement.setString(3, rent.getLastName());
        preparedStatement.setString(4, rent.getEmail());
        preparedStatement.setString(5, rent.getMobile());
        preparedStatement.setString(6, rent.getAddress());
        preparedStatement.setString(7, rent.getPickUpDate());
        preparedStatement.setString(8, rent.getDropOffDate());
        preparedStatement.setDouble(9, rent.getRentalPrice());
        preparedStatement.setInt(10, rent.getRegistrationNo());
        preparedStatement.setInt(11, rent.getRentID());

        int result = preparedStatement.executeUpdate();

        if(result == 1){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public boolean deleteRentalDetails(int rentID) throws SQLException, ClassNotFoundException {

        Connection con = DBConnectionUtil.getConnection();
        String deleteQuery = "DELETE FROM `rasa`.`rent` WHERE `rentID` = ?";
        PreparedStatement preparedStatement = con.prepareStatement(deleteQuery);

        preparedStatement.setInt(1, rentID);

        boolean isDeleted = preparedStatement.execute();

        return isDeleted;

    }

    @Override
    public ArrayList<AvailableCars> searchByBrand(String brand) throws SQLException, ClassNotFoundException {
        ArrayList<AvailableCars> list = new ArrayList<>();

        try{
            Connection con = DBConnectionUtil.getConnection();
            String searchQuery = "SELECT * FROM `rasa`.`rentalvehicle` WHERE brand = ?";
            PreparedStatement preparedStatement = con.prepareStatement(searchQuery);

            preparedStatement.setString(1, brand);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                AvailableCars availableCars = new AvailableCars();

                availableCars.setRegistrationNumber(rs.getInt(1));
                availableCars.setBrand(rs.getString(2));
                availableCars.setModel(rs.getString(3));
                availableCars.setNumberOfSeats(rs.getInt(4));
                availableCars.setPricePerDay(rs.getDouble(5));
                //availableCars.setStatus(rs.getString(6));

                list.add(availableCars);
            }

        }catch (SQLException | ClassNotFoundException | NullPointerException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Rent> retrieveRentalDetailsByYearAndMonth(int year, int month) throws SQLException, ClassNotFoundException {

        Connection con = DBConnectionUtil.getConnection();

        ArrayList<Rent> list = new ArrayList<>();

        String selectQuery = "SELECT `rent`.`rentID`, `rent`.`firstName`, `rent`.`lastName`, `rent`.`email`, `rent`.`phone`, `rent`.`address`, `rent`.`pickUpDate`, `rent`.`dropOffDate`, `rent`.`rentalPrice`, `rent`.`registrationNumber` FROM `rasa`.`rent` WHERE year(`rent`.`pickUpDate`)=? AND month(`rent`.`pickUpDate`)=?;";

        PreparedStatement preparedStatement = con.prepareStatement(selectQuery);

        preparedStatement.setInt(1, year);
        preparedStatement.setInt(2,month);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){
            Rent r = new Rent();

            r.setRentID(rs.getInt(1));
            r.setFirstName(rs.getString(2));
            r.setLastName(rs.getString(3));
            r.setEmail(rs.getString(4));
            r.setMobile(rs.getString(5));
            r.setAddress(rs.getString(6));
            r.setPickUpDate(rs.getString(7));
            r.setDropOffDate(rs.getString(8));
            r.setRentalPrice(rs.getDouble(9));
            r.setRegistrationNo(rs.getInt(10));

            list.add(r);

        }
        return list;
    }

    @Override
    public String month(int month){
        String m = "";
        if(month == 1){
            m =  "January";
        }
        else if(month == 2){
            m = "February";
        }else if(month == 3){
            m = "March";
        }
        else if(month == 4){
            m = "April";
        }
        else if(month == 5){
            m = "May";
        }
        else if(month == 6){
            m = "June";
        }
        else if(month == 7){
            m = "July";
        }
        else if(month == 8){
            m = "August";
        }
        else if(month == 9){
            m = "September";
        }
        else if(month == 10){
            m = "October";
        }
        else if(month == 11){
            m = "November";
        }
        else if(month == 12){
            m = "December";
        }

        return m;
    }

    @Override
    public boolean createRentalDetailsPdf(ArrayList<Rent> rent, int year, int month) throws IOException, DocumentException, SQLException, ClassNotFoundException {
        //date
        LocalDate date = LocalDate.now();

        Document document = new Document();
        //pdf path
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ASUS\\Desktop\\reports"+date+".pdf"));
        document.open();
        //header part
        //font
        Font heading1 = new Font(Font.FontFamily.HELVETICA,13,Font.BOLD, BaseColor.BLUE);
        Font heading2 = new Font(Font.FontFamily.HELVETICA,12,Font.NORMAL,BaseColor.BLUE);

        Chunk head = new Chunk("RASA MOTERS PRIVATE LIMITED",heading1);
        Chunk head3 = new Chunk("rasa moters",heading1);
        Chunk head2 = new Chunk("54/3 New Kandy Road ,Kotalawela,Kaduwela\nHotline:072323435\nemail:Rasa@gmail.com",heading2);

        //image path
        String path = "C:\\Users\\ASUS\\Desktop\\reports\\rasa.jpeg";

        Image img = Image.getInstance(path);
        PdfPTable table1 = new PdfPTable(2); // 3 columns.
        PdfPTable table2 = new PdfPTable(1); // 1 column

        Paragraph p1 = new Paragraph();
        p1.add(head);
        p1.add(head2);

        PdfPCell cell1 = new PdfPCell(img);
        PdfPCell cell2 = new PdfPCell(p1);
        PdfPCell cell3 = new PdfPCell(new Paragraph(head3));

        cell1.setBorderWidth(0);
        cell2.setBorderWidth(0);
        cell3.setBorderWidth(0);
        cell1.setFixedHeight(100);
        cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table1.setWidthPercentage(100);
        table2.setWidthPercentage(200);

        table1.addCell(cell1);
        table1.addCell(cell2);
        table2.addCell(cell3);
        document.add(table2);
        document.add(table1);
        document.add(table2);

        //header part end

        //body for rent details table

        IRentCarService iRentCarService = new RentCarService();
        Paragraph space1 = new Paragraph(" ");
        Paragraph heading3 = new Paragraph("Rent Details Report "+ date);
        String m = month(month);
        Paragraph heading4 = new Paragraph("Year: "+ year + ", Month: "+ m);
        Paragraph space2 = new Paragraph(" ");
        document.add(space1);
        document.add(heading3);
        document.add(heading4);
        document.add(space2);

        //PdfPCell rentID = new PdfPCell(new Paragraph("Rent ID"));
        PdfPCell firstName = new PdfPCell(new Paragraph("First Name"));
        PdfPCell lastName = new PdfPCell(new Paragraph("Last Name"));
        PdfPCell email = new PdfPCell(new Paragraph("Email"));
        PdfPCell pickUpDate = new PdfPCell(new Paragraph("Pick Up Date"));
        PdfPCell dropOffDate = new PdfPCell(new Paragraph("Drop Off Date"));
        PdfPCell rentPrice = new PdfPCell(new Paragraph("Rent Price"));
        PdfPTable pTable = new PdfPTable(6);

        //pTable.addCell(rentID);
        pTable.addCell(firstName);
        pTable.addCell(lastName);
        pTable.addCell(email);
        pTable.addCell(pickUpDate);
        pTable.addCell(dropOffDate);
        pTable.addCell(rentPrice);

        for(Rent rs : rent){
            ArrayList<Rent> r = iRentCarService.retrieveRentalDetails();

            PdfPCell pdfPCell1 = new PdfPCell(new Paragraph(rs.getFirstName()));
            PdfPCell pdfPCell2 = new PdfPCell(new Paragraph(rs.getLastName()));
            PdfPCell pdfPCell3 = new PdfPCell(new Paragraph(rs.getEmail()));
            PdfPCell pdfPCell4 = new PdfPCell(new Paragraph(rs.getPickUpDate()));
            PdfPCell pdfPCell5 = new PdfPCell(new Paragraph(rs.getDropOffDate()));
            PdfPCell pdfPCell6 = new PdfPCell(new Paragraph(String.valueOf(rs.getRentalPrice())));

            pTable.addCell(pdfPCell1);
            pTable.addCell(pdfPCell2);
            pTable.addCell(pdfPCell3);
            pTable.addCell(pdfPCell4);
            pTable.addCell(pdfPCell5);
            pTable.addCell(pdfPCell6);

            document.add(pTable);
            pTable.deleteBodyRows();
            r.clear();

        }

        document.close();

        //body end
        return true;
    }

}