package com.rasa.service;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rasa.model.paymentList;
import com.rasa.util.DBConnectionUtil;

public class paymentService implements ipayment{


    public paymentService() {

    }
    public Connection connection;
    // method for insert payments
    public void addPayment(paymentList paymentlist) throws SQLException {

        try{
            connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO rasa.payment "+" (registrationNumber,estimateAmount,cash,paymentDate,sid)VALUES "+" (?,?,?,?,?)");
            preparedStatement.setString(1,paymentlist.getRegistrationNumber());

            preparedStatement.setDouble(2,paymentlist.getEstimateAmount());

            preparedStatement.setDouble(3,paymentlist.getCash());
            preparedStatement.setDate(4, paymentlist.getPaymentDate());
            preparedStatement.setInt(5, paymentlist.getSid());

            System.out.println(preparedStatement);
            preparedStatement.executeLargeUpdate();

        }catch(SQLException | ClassNotFoundException e){

            printSQLException((SQLException) e);

        }


    }

    public paymentList selectPayment(int payId){


        paymentList paymentlist=null;

        try{
            connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT payId,registrationNumber,estimateAmount,cash,paymentDate, sid FROM rasa.payment WHERE payId = ?");
            preparedStatement.setInt(1,payId);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                String registrationNumber = rs.getString("registrationNumber");

                double estimateAmount = rs.getDouble("estimateAmount");

                double cash = rs.getDouble("cash");
                Date paymentDate= rs.getDate("paymentDate");
                int  sid = rs.getInt("sid");


                paymentlist = new paymentList(payId,registrationNumber, estimateAmount, cash, paymentDate, sid);
            }
            System.out.println(preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return paymentlist;

    }

    public  List<paymentList> selectAllPayment(){

        List<paymentList> pays = new ArrayList<>();

        try{
            connection = DBConnectionUtil.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM rasa.payment");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int payId = rs.getInt("payId");
                String registrationNumber = rs.getString("registrationNumber");

                double estimateAmount = rs.getDouble("estimateAmount");

                double cash = rs.getDouble("cash");
                Date paymentDate = rs.getDate("paymentDate");
                int  sid = rs.getInt("sid");

                pays.add(new paymentList(payId,registrationNumber,estimateAmount,cash,paymentDate,sid));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return pays;
    }


    //method for delete payment
    public  boolean deletePayment(int payId)throws SQLException{
        paymentList paymentlist=null;
        boolean rowDeleted = false;
        try {

            connection = DBConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM rasa.payment WHERE payId = ?");
            System.out.println(statement);

            statement.setInt(1,payId);
            //use to update the query
            rowDeleted = statement.executeUpdate() > 0;//return number of rows deleted
        }catch (SQLException | ClassNotFoundException e) {
            printSQLException((SQLException) e);
        }
        return rowDeleted;


    }



    public  boolean updatePayment(paymentList paymentlist) throws SQLException {
        boolean rowUpdated = false;
        try {


            connection = DBConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE payment set registrationNumber = ?,estimateAmount = ?,cash = ? ,paymentDate = ? where payId = ?");

            statement.setString(1, paymentlist.getRegistrationNumber());

            statement.setDouble(2, paymentlist.getEstimateAmount());

            statement.setDouble(3,paymentlist.getCash());
            statement.setDate(4,paymentlist.getPaymentDate());

            statement.setInt(5, paymentlist.getPayId());
            System.out.println(statement);

            rowUpdated = statement.executeUpdate() > 0;//return number of rows updated
        }catch (SQLException | ClassNotFoundException e) {
            printSQLException((SQLException) e);
        }
        return rowUpdated;
    }

    public paymentList showLatestPayment() {

        paymentList payLatest = new  paymentList();

        try {

            connection = DBConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * from payment order by payId desc limit 1");



            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int payId = rs.getInt("payId");
                String registrationNumber = rs.getString("registrationNumber");

                double estimateAmount = rs.getDouble("estimateAmount");

                double cash = rs.getDouble("cash");
                Date paymentDate = rs.getDate("paymentDate");
                int  sid = rs.getInt("sid");

                payLatest = new paymentList(payId,registrationNumber, estimateAmount, cash, paymentDate, sid);
                System.out.println(statement);


            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return payLatest;

    }

    public void billGenerate(int payId)throws DocumentException, MalformedURLException, IOException,SQLException {
        paymentList pay  =  selectPayment(payId);


        try {

            //AllMethods(year,month);
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\asus\\Desktop\\reports\\billReceipt" + ".pdf"));
            document.open();
            //header part
            //font
            Font heading1 = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD, BaseColor.BLUE);
            Font heading2 = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLUE);
            Font heading3 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);

            Chunk head = new Chunk("RASA MOTERS PRIVATE LIMITED", heading1);
            Chunk head3 = new Chunk("rasa moters", heading1);
            Chunk head2 = new Chunk("54/3 New Kandy Road ,Kotalawela,Kaduwela\nHotline:072323435\nemail:Rasa@gmail.com", heading2);

            //image path
            String path = "C:\\Users\\asus\\Desktop\\reports\\rasa.jpeg";
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



            Font BillName = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD, BaseColor.BLUE);
            Paragraph p = new Paragraph("Bill Information",BillName);
            p.setAlignment(Paragraph.ALIGN_CENTER);

            p.setSpacingAfter(60);
            document.add(p);

            float colWidth[] = {150 ,250,100,80};

            PdfPTable table3 = new PdfPTable(4); //4 columns.

            table3.setWidths(colWidth);





            PdfPCell cell4 = new PdfPCell(new Paragraph("Vehicle Number : "));
            PdfPCell cell5 = new PdfPCell(new Paragraph(String.valueOf(pay.getRegistrationNumber())));

            PdfPCell cell6 = new PdfPCell(new Paragraph("payment ID : "));
            PdfPCell cell7= new PdfPCell(new Paragraph(String.valueOf(pay.getPayId())));





            PdfPCell cell8 = new PdfPCell(new Paragraph("Payment Date : "));
            PdfPCell cell9 = new PdfPCell(new Paragraph(String.valueOf(pay.getPaymentDate())));
            PdfPCell cell10 = new PdfPCell(new Paragraph("Service ID  : "));
            PdfPCell cell11= new PdfPCell(new Paragraph(String.valueOf(pay.getSid())));

            table3.setSpacingAfter(25);

            float colWidth2[] = {70,70};

            PdfPTable table4 = new PdfPTable(2);
            table4.setWidths(colWidth2);

            PdfPCell cell12 = new PdfPCell(new Paragraph("Estimated Amount"));
            cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell cell13 = new PdfPCell(new Paragraph(String.valueOf(pay.getEstimateAmount())));


            PdfPCell cell14 = new PdfPCell(new Paragraph("Paid Cash"));
            cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell cell15 = new PdfPCell(new Paragraph(String.valueOf(pay.getCash())));

            table4.setSpacingAfter(70);


            Paragraph p4 = new Paragraph("................");
            p4.setAlignment(Element.ALIGN_RIGHT);
            document.add(p4);

            Paragraph p5 = new Paragraph("Signature");
            p5.setAlignment(Element.ALIGN_RIGHT);
            document.add(p5);
            p4.setSpacingBefore(70);
            p4.setSpacingAfter(20);

            PdfPTable table6 = new PdfPTable(1);
            PdfPCell cell16 = new PdfPCell(new Paragraph("**************End**************"));




            cell4.setBorderWidth(0);

            cell5.setBorderWidth(0);
            cell6.setBorderWidth(0);
            cell7.setBorderWidth(0);
            cell8.setBorderWidth(0);
            cell9.setBorderWidth(0);
            cell10.setBorderWidth(0);
            cell11.setBorderWidth(0);

            //table3.setWidthPercentage(100);
            cell4.setFixedHeight(25);
            cell8.setFixedHeight(25);
            cell12.setFixedHeight(25);
            cell14.setFixedHeight(25);


            table3.addCell(cell4);

            table3.addCell(cell5);
            table3.addCell(cell6);
            table3.addCell(cell7);
            table3.addCell(cell8);
            table3.addCell(cell9);
            table3.addCell(cell10);
            table3.addCell(cell11);
            table4.addCell(cell12);
            table4.addCell(cell13);
            table4.addCell(cell14);
            table4.addCell(cell15);
            table6.addCell(cell16);


            document.add(table3);
            document.add(table4);
            document.add(table6);


            document.close();










        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private static void printSQLException(SQLException ex) {
        for(Throwable e:ex)
            if (e instanceof SQLException) {

                e.printStackTrace(System.err);
                System.err.println("SQLState:" + ((SQLException) e).getSQLState());
                System.err.println("Error Code:" + ((SQLException) e).getErrorCode());
                System.err.println("Message:" + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause:" + t);
                    t = t.getCause();
                }

            }
    }

    }











