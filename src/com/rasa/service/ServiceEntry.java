package com.rasa.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rasa.model.Customer;
import com.rasa.model.Repair;
import com.rasa.model.Vehicle;
import com.rasa.util.CustomerManagementQuery;
import com.rasa.util.DBConnectionUtil;
import com.rasa.util.QueryConstants;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

public class ServiceEntry implements IServiceEntry{

    /** REFERENCE FOR CONNECTION **/
    private static Connection conn;

    private PreparedStatement preparedStatement;

    @Override
    public boolean addServiceEntry(String registrationNumber,String nic, String ServiceType, String entryDate, String accidentDate, boolean customerNoObjection, boolean insuranceNoObjection, boolean claimForm) {

        try {
            conn = DBConnectionUtil.getConnection();
            String sql = "";

            if (ServiceType.equals("insurance")){
                sql = CustomerManagementQuery.ADD_CASH_SERVICE;
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(QueryConstants.COLUMN_ONE,registrationNumber);
                preparedStatement.setString(QueryConstants.COLUMN_TWO,entryDate);
                preparedStatement.setString(QueryConstants.COLUMN_THREE,accidentDate);
                preparedStatement.setString(QueryConstants.COLUMN_FOUR,ServiceType);
                preparedStatement.setString(QueryConstants.COLUMN_FIVE,nic);
                preparedStatement.setString(QueryConstants.COLUMN_SIX,"Incomplete");
            }else {
                sql = CustomerManagementQuery.ADD_INSURANCE_SERVICE;
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(QueryConstants.COLUMN_ONE,registrationNumber);
                preparedStatement.setString(QueryConstants.COLUMN_TWO,entryDate);
                preparedStatement.setString(QueryConstants.COLUMN_THREE,accidentDate);
                preparedStatement.setBoolean(QueryConstants.COLUMN_FOUR,customerNoObjection);
                preparedStatement.setBoolean(QueryConstants.COLUMN_FIVE,insuranceNoObjection);
                preparedStatement.setBoolean(QueryConstants.COLUMN_SIX,claimForm);
                preparedStatement.setString(QueryConstants.COLUMN_SEVEN,ServiceType);
                preparedStatement.setString(QueryConstants.COLUMN_EIGHT,nic);
                preparedStatement.setString(QueryConstants.COLUMN_NINE,"Incomplete");
            }

            preparedStatement.execute();

        }catch (SQLException | ClassNotFoundException  e){
            e.printStackTrace();
            return false;
        }finally {
            DBConnectionUtil.closeConnection(preparedStatement, conn);
        }
        return true;
    }

    @Override
    public ArrayList<Repair> searchByRegistrationNumber(String registrationNumber) {
        ArrayList<Repair> repairList = new ArrayList<>();
        try {
            conn = DBConnectionUtil.getConnection();
            String sql = CustomerManagementQuery.SEARCH_ENTRY_BY_REG_NUM;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(QueryConstants.COLUMN_ONE,registrationNumber.toUpperCase());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Repair repair = new Repair();
                repair.setVehicleRegistrationNo(resultSet.getString("registrationNumber"));
                repair.setEntryDate(resultSet.getString("entryDate"));
                repair.setAccidentDate(resultSet.getString("accidentDate"));
                repair.setCustomerNoObjection(resultSet.getBoolean("customerNoObjection"));
                repair.setLeasingNoObjection(resultSet.getBoolean("insuranceNoObjection"));
                repair.setClaimForm(resultSet.getBoolean("claimForm"));
                repair.setProgress(resultSet.getString("progress"));
                repair.setPaymentType(resultSet.getString("type"));
                repair.setRepairId(resultSet.getInt("serivceID"));
                repair.setProgress(resultSet.getString("progress"));

                repairList.add(repair);
            }

        }catch (SQLException | ClassNotFoundException  e){
            e.printStackTrace();
        }finally {
            DBConnectionUtil.closeConnection(preparedStatement, conn);
        }

        return repairList;
    }

    @Override
    public ArrayList<Repair> searchByRegistrationNic(String nicNumber) {

        ArrayList<Repair> repairList = new ArrayList<>();

        try {
            conn = DBConnectionUtil.getConnection();
            String sql = CustomerManagementQuery.SEARCH_ENTRY_BY_NIC_NUM;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(QueryConstants.COLUMN_ONE,nicNumber.toUpperCase());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Repair repair = new Repair();
                repair.setVehicleRegistrationNo(resultSet.getString("registrationNumber"));
                repair.setEntryDate(resultSet.getString("entryDate"));
                repair.setAccidentDate(resultSet.getString("accidentDate"));
                repair.setCustomerNoObjection(resultSet.getBoolean("customerNoObjection"));
                repair.setLeasingNoObjection(resultSet.getBoolean("insuranceNoObjection"));
                repair.setClaimForm(resultSet.getBoolean("claimForm"));
                repair.setProgress(resultSet.getString("progress"));
                repair.setPaymentType(resultSet.getString("type"));
                repair.setRepairId(resultSet.getInt("serivceID"));
                repairList.add(repair);
            }

        }catch (SQLException | ClassNotFoundException  e){
            e.printStackTrace();
        }finally {
            DBConnectionUtil.closeConnection(preparedStatement, conn);
        }
        return repairList;
    }

    @Override
    public Repair getRepairByServiceID(int serviceID) {
        Repair repair = new Repair();

        try {
            conn = DBConnectionUtil.getConnection();
            String sql = CustomerManagementQuery.GET_SERVICE_BY_SERVICE_ID;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(QueryConstants.COLUMN_ONE,serviceID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                repair.setRepairId(resultSet.getInt("serivceID"));
                repair.setVehicleRegistrationNo(resultSet.getString("registrationNumber"));
                repair.setEntryDate(resultSet.getString("entryDate"));
                repair.setAccidentDate(resultSet.getString("accidentDate"));
                repair.setCustomerNoObjection(resultSet.getBoolean("customerNoObjection"));
                repair.setLeasingNoObjection(resultSet.getBoolean("insuranceNoObjection"));
                repair.setClaimForm(resultSet.getBoolean("claimForm"));
                repair.setPaymentType(resultSet.getString("type"));
                repair.setProgress(resultSet.getString("progress"));
                repair.setNICno(resultSet.getString("NICnumber"));
            }

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            DBConnectionUtil.closeConnection(preparedStatement, conn);
        }

        return repair;
    }

    @Override
    public Boolean deleteServiceEntry(int serviceID) {
        try {
            conn = DBConnectionUtil.getConnection();
            String sql = CustomerManagementQuery.DELETE_SERVICE_ENTRY;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(QueryConstants.COLUMN_ONE,serviceID);
            preparedStatement.execute();

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }finally {
            DBConnectionUtil.closeConnection(preparedStatement, conn);
        }
        return true;
    }

    @Override
    public Boolean updateServiceEntry(
            int serviceID,
            String ServiceType,
            String entryDate,
            String accidentDate,
            boolean  customerNoObjection,
            boolean insuranceNoObjection,
            boolean claimForm
    ) {
        try{
            conn = DBConnectionUtil.getConnection();
            String sql = "";

            ServiceType="insurance";

            if (ServiceType.equals("insurance")){
                sql = CustomerManagementQuery.UPDATE_CASH_SERVICE_ENTRY;
                preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setString(QueryConstants.COLUMN_ONE,entryDate);
                preparedStatement.setString(QueryConstants.COLUMN_TWO,accidentDate);
                preparedStatement.setInt(QueryConstants.COLUMN_THREE,serviceID);
            }else {
                sql = CustomerManagementQuery.UPDATE_INSURANCE_SERVICE_ENTRY;
                preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setString(QueryConstants.COLUMN_ONE,entryDate);
                preparedStatement.setString(QueryConstants.COLUMN_TWO,accidentDate);
                preparedStatement.setBoolean(QueryConstants.COLUMN_THREE,customerNoObjection);
                preparedStatement.setBoolean(QueryConstants.COLUMN_FOUR,insuranceNoObjection);
                preparedStatement.setBoolean(QueryConstants.COLUMN_FIVE,claimForm);
                preparedStatement.setInt(QueryConstants.COLUMN_SIX,serviceID);
            }

            preparedStatement.executeUpdate();

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }finally {
            DBConnectionUtil.closeConnection(preparedStatement, conn);
        }
        return true;
    }

    @Override
    public boolean generateServiceReport(Customer customer, Vehicle vehicle, Repair repair) throws IOException, DocumentException, SQLException, ClassNotFoundException{

        //date
        LocalDate date = LocalDate.now();

        Document document = new Document();
        //pdf path
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ACER\\Desktop\\reports\\service "+repair.getRepairId()+".pdf"));
        document.open();


//        header part
//        font
        Font heading1 = new Font(Font.FontFamily.HELVETICA,13,Font.BOLD, BaseColor.BLUE);
        Font heading2 = new Font(Font.FontFamily.HELVETICA,12,Font.NORMAL,BaseColor.BLUE);

        Chunk head = new Chunk("RASA MOTERS PRIVATE LIMITED",heading1);
        Chunk head3 = new Chunk("rasa moters",heading1);
        Chunk head2 = new Chunk("54/3 New Kandy Road ,Kotalawela,Kaduwela\nHotline:072323435\nemail:Rasa@gmail.com",heading2);

        //image path
        String path = "C:\\Users\\ACER\\Desktop\\reports\\logo.jpeg";

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

        //report body
        Paragraph headingEstimate = new Paragraph("Service Report : "+ date);
        Paragraph VehicleNo = new Paragraph("Vehicle No :"+ vehicle.getRegistrationNo().toUpperCase());
        Paragraph serviceNo = new Paragraph("Service No :"+ repair.getRepairId());
        Paragraph space2 = new Paragraph(" ");
        document.add(headingEstimate);
        document.add(VehicleNo);
        document.add(serviceNo);
        document.add(space2);

        /**Customer details table*/
        PdfPTable pTable = new PdfPTable(2);

        pTable.setSpacingBefore(10f); //Space before table
        pTable.setSpacingAfter(10f); //Space after table

        //Set Column widths
        float[] columnWidths = {1f, 2f};
        pTable.setWidths(columnWidths);
        PdfPCell name = new PdfPCell(new Paragraph("Customer Name"));
        PdfPCell nameValue = new PdfPCell(new Paragraph(customer.getFirstName() + " " + customer.getLastName()));
        pTable.addCell(name);
        pTable.addCell(nameValue);

        PdfPCell nic = new PdfPCell(new Paragraph("Customer NIC"));
        PdfPCell nicValue = new PdfPCell(new Paragraph(customer.getNICno().toUpperCase()));
        pTable.addCell(nic);
        pTable.addCell(nicValue);

        PdfPCell email = new PdfPCell(new Paragraph("Email Address"));
        PdfPCell emailValue = new PdfPCell(new Paragraph(customer.getEmail()));
        pTable.addCell(email);
        pTable.addCell(emailValue);

        PdfPCell mobile = new PdfPCell(new Paragraph("Mobile"));
        PdfPCell mobileValue = new PdfPCell(new Paragraph(customer.getPhoneNo()));
        pTable.addCell(mobile);
        pTable.addCell(mobileValue);

        PdfPCell address = new PdfPCell(new Paragraph("Customer Address"));
        PdfPCell addressValue = new PdfPCell(new Paragraph(customer.getAddress()));
        pTable.addCell(address);
        pTable.addCell(addressValue);

        /**vehicle details table*/

//        Paragraph vehicleTableHeading = new Paragraph("Vehicle Details ");
//        document.add(space2);
//        document.add(vehicleTableHeading);
//        document.add(space2);

        PdfPCell registrationNumber = new PdfPCell(new Paragraph("Registration Number"));
        PdfPCell registrationNumberValue = new PdfPCell(new Paragraph(vehicle.getRegistrationNo().toUpperCase()));
        pTable.addCell(registrationNumber);
        pTable.addCell(registrationNumberValue);

        PdfPCell brand = new PdfPCell(new Paragraph("Vehicle Brand"));
        PdfPCell brandValue = new PdfPCell(new Paragraph(vehicle.getBrand()));
        pTable.addCell(brand);
        pTable.addCell(brandValue);

        PdfPCell modal = new PdfPCell(new Paragraph("Vehicle Model"));
        PdfPCell modalValue = new PdfPCell(new Paragraph(vehicle.getModel()));
        pTable.addCell(modal);
        pTable.addCell(modalValue);

        PdfPCell color = new PdfPCell(new Paragraph("Vehicle Color"));
        PdfPCell colorValue = new PdfPCell(new Paragraph(vehicle.getColor()));
        pTable.addCell(color);
        pTable.addCell(colorValue);

        PdfPCell manufactYear = new PdfPCell(new Paragraph("Manufacture Year"));
        PdfPCell manufactYearValue = new PdfPCell(new Paragraph(""+vehicle.getYear()));
        pTable.addCell(manufactYear);
        pTable.addCell(manufactYearValue);

        /**Service details table*/
//        Paragraph serviceTableHeading = new Paragraph("Service Details ");
//        document.add(space2);
//        document.add(serviceTableHeading);
//        document.add(space2);

        PdfPCell serviceType = new PdfPCell(new Paragraph("Service Type"));
        PdfPCell serviceTypeYearValue = new PdfPCell(new Paragraph(repair.getPaymentType()));
        pTable.addCell(serviceType);
        pTable.addCell(serviceTypeYearValue);

        PdfPCell entryDate = new PdfPCell(new Paragraph("Entry Date"));
        PdfPCell entryDateValue = new PdfPCell(new Paragraph(repair.getEntryDate()));
        pTable.addCell(entryDate);
        pTable.addCell(entryDateValue);

        PdfPCell accidentDate = new PdfPCell(new Paragraph("Accident Date"));
        PdfPCell accidentDateValue = new PdfPCell(new Paragraph(repair.getAccidentDate()));
        pTable.addCell(accidentDate);
        pTable.addCell(accidentDateValue);


        document.add(pTable);
        pTable.deleteBodyRows();
        document.close();

        return true;
    }
}
