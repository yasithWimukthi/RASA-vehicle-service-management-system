package com.rasa.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rasa.model.Budget;
import com.rasa.util.DBConnectionUtil;


import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;


public class budgetService {

    static Connection connection;


    public double CalRepairAmount(String year, String month) {
        double repairAmount = 0;
        double totalAmount = 0;
        try {
            connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT cash FROM rasa.payment WHERE EXTRACT(year FROM paymentDate) =? AND EXTRACT(month FROM paymentDate) = ?; ");

            preparedStatement.setString(1, year);
            preparedStatement.setString(2, month);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                repairAmount = resultSet.getDouble(1);
                totalAmount = totalAmount + repairAmount;

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return totalAmount;
    }


    public double calRentals(String year, String month) {
        double rentalAmount = 0;
        double totalRentalAmount = 0;

        try {
            connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT rentalPrice FROM rasa.rent WHERE EXTRACT(year FROM dropOffDate) =? AND EXTRACT(month FROM dropOffDate) = ?; ");


            preparedStatement.setString(1, year);
            preparedStatement.setString(2, month);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                rentalAmount = resultSet.getDouble(1);
                totalRentalAmount = totalRentalAmount + rentalAmount;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return totalRentalAmount;

    }



    public double calEmpPayments(String year, String month) {
        double empPayments = 0;
        double totalEmpPayments = 0;
        try {
            connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT amount FROM emppayment  WHERE  EXTRACT(year FROM date) =? AND EXTRACT(month FROM date) = ?;");

            preparedStatement.setString(1, year);
            preparedStatement.setString(2, month);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                empPayments = resultSet.getDouble(1);
                totalEmpPayments = totalEmpPayments + empPayments;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return totalEmpPayments;
    }


    public double calInventoryExpenses(String year, String month) {
        double inventoryExpenses = 0;
        double totalInventoryExpenses = 0;
        try {
            connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT (price * quantity) FROM rasa.item WHERE EXTRACT(year FROM date) =? AND EXTRACT(month FROM date) = ?;");

            preparedStatement.setString(1, year);
            preparedStatement.setString(2, month);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                inventoryExpenses = resultSet.getDouble(1);
                totalInventoryExpenses = totalInventoryExpenses + inventoryExpenses;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return totalInventoryExpenses;


    }


    public Budget AllMethods(String year, String month) {
        System.out.println(year + month);
        Double CalRepairAmount = CalRepairAmount(year, month);
        Double calRentals = calRentals(year, month);
        Double calInventoryExpenses = calInventoryExpenses(year, month);
        Double calEmpPayments = calEmpPayments(year, month);


        Double totIncome = CalRepairAmount + calRentals;
        Double totExpenses = calInventoryExpenses + calEmpPayments;
        Double profit = totIncome - totExpenses;
        Budget bd = new Budget(totIncome, CalRepairAmount, calRentals, totExpenses, calInventoryExpenses, calEmpPayments, profit);

        return bd;

    }

    public boolean BudgetReport(String year, String month) throws DocumentException, MalformedURLException, IOException, SQLException {
        Budget bd = new Budget();
        // String year = bd.getYear();

        //String month = bd.getMonth();
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd  HH.mm.ss").format(Calendar.getInstance().getTime());
        try {

            //AllMethods(year,month);
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\asus\\Desktop\\reports\\budget " +timeStamp+".pdf"));
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


            Font datedEC = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD, BaseColor.BLACK);


            LocalDate date = LocalDate.now();
            Paragraph main = new Paragraph("Date  " + date);
            main.setSpacingAfter(40);
            document.add(main);

            Font titleDec = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD, BaseColor.BLUE);
            Paragraph title = new Paragraph("Budget Report",titleDec);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(55);

            document.add(title);
            //income details
            Paragraph p = new Paragraph("Income Details", datedEC);
            p.setSpacingAfter(25);
            document.add(p);


            PdfPTable table3 = new PdfPTable(2); // 2 columns.
            table3.setWidths(new int[]{90, 120});

            Font IncomeTitle = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
            PdfPCell cell4 = new PdfPCell(new Paragraph("Income Type",IncomeTitle));
            cell4.setFixedHeight(25);


            table3.addCell(cell4);

            cell4 = new PdfPCell(new Paragraph("Amount",IncomeTitle));

            table3.addCell(cell4);

            table3.setHeaderRows(1);
            cell4.setFixedHeight(25);

            table3.addCell(new Paragraph("vehicle repair"));
            table3.addCell(new Paragraph("Rs :" + String.valueOf(CalRepairAmount(year, month))));


            table3.addCell(new Paragraph("vehicle rentals"));
            table3.addCell(new Paragraph("Rs :" + String.valueOf(calRentals(year, month))));

            table3.addCell(new Paragraph("Total Income"));
            table3.addCell(new Paragraph("Rs :" + String.valueOf(calRentals(year, month) + CalRepairAmount(year, month))));
            table3.setSpacingAfter(25);
            document.add(table3);


            //Expenses Details
            Paragraph p4 = new Paragraph("Expenses Details", datedEC);
            p4.setSpacingAfter(25);
            document.add(p4);

            PdfPTable table4 = new PdfPTable(2); // 3 columns.
            table4.setWidths(new int[]{90, 120});

            PdfPCell cell5 = new PdfPCell(new Paragraph("Expenses Type",IncomeTitle));
            table4.addCell(cell5);

            cell5 = new PdfPCell(new Paragraph("Amount",IncomeTitle));
            table4.addCell(cell5);
            cell5.setFixedHeight(25);

            table4.setHeaderRows(1);
            table4.addCell(new Paragraph("employee Payments"));
            table4.addCell(new Paragraph("Rs :" + String.valueOf(calEmpPayments(year, month))));

            table4.addCell(new Paragraph("Inventry Expenses"));
            table4.addCell(new Paragraph("Rs :" + String.valueOf(calInventoryExpenses(year, month))));

            table4.addCell(new Paragraph("Total Expenses"));
            table4.addCell(new Paragraph("Rs :" + String.valueOf(calRentals(year, month) + calInventoryExpenses(year, month))));

            table4.setSpacingAfter(25);
            document.add(table4);

            //profit details
            Paragraph p5 = new Paragraph("Profit Details", datedEC);
            p5.setSpacingAfter(25);
            document.add(p5);

            PdfPTable table5 = new PdfPTable(2);
            table5.setWidths(new int[]{90, 120});
            PdfPCell cell6 = new PdfPCell(new Paragraph("Profit Amount",IncomeTitle));
            table5.addCell(cell6);

            cell6 = new PdfPCell(new Paragraph("Rs :"+String.valueOf((calRentals(year, month) + CalRepairAmount(year, month)) - (calRentals(year, month) + calInventoryExpenses(year, month)))));
            table5.addCell(cell6);
            cell6.setFixedHeight(25);
            document.add(table5);
            document.close();

        } catch (Exception e) {
            System.err.println(e);
        }

        return true;
    }
}
