package com.rasa.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rasa.model.EmployeeAdvance;
import com.rasa.model.EmployeePayment;
import com.rasa.util.DBConnectionUtil;
import com.rasa.util.EmpQuery;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmpPayReportService {

    Connection con;
    PreparedStatement preparedStatement;

    public void salaryReport(String year,String month){

        ArrayList<EmployeePayment> list = new ArrayList<>();
        try {
            con = DBConnectionUtil.getConnection();
            String sql = "select * from salary where EXTRACT(year from pay_date)="+year+" and EXTRACT(month from pay_date)="+month;
            preparedStatement=con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){

                EmployeePayment employeePayment = new EmployeePayment();
                employeePayment.setEmpID(rs.getInt(3));
                employeePayment.setDate(rs.getDate(2));
                employeePayment.setBonus(rs.getDouble(4));
                employeePayment.setDeduct(rs.getDouble(5));
                employeePayment.setAmount(rs.getDouble(6));

                list.add(employeePayment);

            }

            Document document = new Document();
            PdfWriter.getInstance(document,new FileOutputStream("F:\\salary "+month+".pdf"));
            document.open();

            Font heading1 = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD, BaseColor.BLUE);
            Font heading2 = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLUE);
            Font heading3 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
            int count =1;

            Chunk head = new Chunk("RASA MOTERS PRIVATE LIMITED", heading1);
            Chunk head3 = new Chunk("rasa moters", heading1);
            Chunk head2 = new Chunk("\n54/3 New Kandy Road ,Kotalawela,Kaduwela\nHotline:072323435\nemail:Rasa@gmail.com", heading2);

            //image path
            String path = "F:\\rasa.jpg";
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


            LocalDate date = LocalDate.now();
            Paragraph main = new Paragraph("Date  " + date);
            main.setSpacingAfter(40);
            document.add(main);

            Font titleDec = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD, BaseColor.BLUE);
            Paragraph title = new Paragraph("Salary Report month-"+month,titleDec);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(55);
            document.add(title);


            PdfPTable table3 = new PdfPTable(6); // 6 columns.
            table3.setWidths(new int[]{50,50,80,80,80,80});

            Font paymentTitle = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
            PdfPCell cell4 = new PdfPCell(new Paragraph("Salary ID",paymentTitle));
            cell4.setFixedHeight(25);
            table3.addCell(cell4);
            cell4 = new PdfPCell(new Paragraph("Employee ID",paymentTitle));
            table3.addCell(cell4);
            cell4 = new PdfPCell(new Paragraph("Date",paymentTitle));
            table3.addCell(cell4);
            cell4 = new PdfPCell(new Paragraph("Bonus",paymentTitle));
            table3.addCell(cell4);
            cell4 = new PdfPCell(new Paragraph("Deduct",paymentTitle));
            table3.addCell(cell4);
            cell4 = new PdfPCell(new Paragraph("Amount",paymentTitle));
            table3.addCell(cell4);

            table3.setHeaderRows(1);
            cell4.setFixedHeight(25);

            for(EmployeePayment i :list){

                table3.addCell(new Paragraph(String.valueOf(count)));
                table3.addCell(new Paragraph(String.valueOf(i.getEmpID())));
                table3.addCell(new Paragraph(String.valueOf(i.getDate())));
                table3.addCell(new Paragraph(String.valueOf(i.getBonus())));
                table3.addCell(new Paragraph(String.valueOf(i.getDeduct())));
                table3.addCell(new Paragraph(String.valueOf(i.getAmount())));
               count++;
            }
            table3.setSpacingAfter(25);
            document.add(table3);
            count=1;

            document.close();

        }catch(Exception e){

            e.printStackTrace();
        }


    }

    public void advanceReport(String year, String month){

        ArrayList<EmployeeAdvance> list = new ArrayList<>();
        try {
            con = DBConnectionUtil.getConnection();
            String sql = "select * from advance where EXTRACT(year from adv_date)="+year+" and EXTRACT(month from adv_date)="+month;
            preparedStatement=con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){

                EmployeeAdvance emp = new EmployeeAdvance();
                emp.setEmpID(rs.getInt(3));
                emp.setDate(rs.getDate(2));
                emp.setAmount(rs.getDouble(4));


                list.add(emp);

            }

            Document document = new Document();
            PdfWriter.getInstance(document,new FileOutputStream("F:\\advance "+month+".pdf"));
            document.open();

            Font heading1 = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD, BaseColor.BLUE);
            Font heading2 = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLUE);
            Font heading3 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
            int count =1;

            Chunk head = new Chunk("RASA MOTERS PRIVATE LIMITED", heading1);
            Chunk head3 = new Chunk("rasa moters", heading1);
            Chunk head2 = new Chunk("\n54/3 New Kandy Road ,Kotalawela,Kaduwela\nHotline:072323435\nemail:Rasa@gmail.com", heading2);

            //image path
            String path = "F:\\rasa.jpg";
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


            LocalDate date = LocalDate.now();
            Paragraph main = new Paragraph("Date  " + date);
            main.setSpacingAfter(40);
            document.add(main);

            Font titleDec = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD, BaseColor.BLUE);
            Paragraph title = new Paragraph("Advance Report month-"+month,titleDec);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(55);
            document.add(title);


            PdfPTable table3 = new PdfPTable(4); // 4 columns.
            table3.setWidths(new int[]{50,50,80,80});

            Font paymentTitle = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
            PdfPCell cell4 = new PdfPCell(new Paragraph("Salary ID",paymentTitle));
            cell4.setFixedHeight(25);
            table3.addCell(cell4);
            cell4 = new PdfPCell(new Paragraph("Employee ID",paymentTitle));
            table3.addCell(cell4);
            cell4 = new PdfPCell(new Paragraph("Date",paymentTitle));
            table3.addCell(cell4);
            cell4 = new PdfPCell(new Paragraph("Amount",paymentTitle));
            table3.addCell(cell4);


            table3.setHeaderRows(1);
            cell4.setFixedHeight(25);

            for(EmployeeAdvance i :list){

                table3.addCell(new Paragraph(String.valueOf(count)));
                table3.addCell(new Paragraph(String.valueOf(i.getEmpID())));
                table3.addCell(new Paragraph(String.valueOf(i.getDate())));
                table3.addCell(new Paragraph(String.valueOf(i.getAmount())));

                count++;
            }
            table3.setSpacingAfter(25);
            document.add(table3);
            count=1;

            document.close();

        }catch(Exception e){

            e.printStackTrace();
        }
    }
}
