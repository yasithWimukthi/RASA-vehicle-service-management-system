package com.rasa.service;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rasa.model.Employee;
import com.rasa.util.DBConnectionUtil;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.itextpdf.text.Font.FontFamily.HELVETICA;


public class employeeService implements IEmployee_Details{
    private static Connection con;
    private static PreparedStatement preparedStatement;



    @Override
    public void addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        try {
            con = DBConnectionUtil.getConnection();
            // String sql = EmpQuery.add_emp;
            String sql="INSERT INTO item_db.employee(fname,lname,gender,DOB,NIC,basicSalary,mobile,email,address,joinDate) VALUES (?,?,?,?,?,?,?,?,?,?)";
            preparedStatement=con.prepareStatement(sql);

            preparedStatement.setString(1,employee.getFname());
            preparedStatement.setString(2,employee.getLname());
            preparedStatement.setString(3,employee.getGender());
            preparedStatement.setString(4,employee.getDOB());
            preparedStatement.setString(5,employee.getNIC());
            preparedStatement.setDouble(6,employee.getBasicSalary());
            preparedStatement.setString(7,employee.getMobile());
            preparedStatement.setString(8,employee.getEmail());
            preparedStatement.setString(9,employee.getAddress());
            preparedStatement.setString(10,employee.getJoinDate());

            preparedStatement.execute();
            System.out.println("Data Insert Successfully");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void EmployeeUpdate(Employee employee)throws SQLException {


        try {
            con = DBConnectionUtil.getConnection();
            PreparedStatement statement =con.prepareStatement
                    ("update item_db.employee set employeeID=? ,fname=?,lname=?,gender=?,DOB=?,NIC=?" +
                            ",basicSalary=?,mobile=?,email=?,address=? where employeeID="+String.valueOf(employee.getEmployeeID()));
            statement.setInt(1,employee.getEmployeeID());
            statement.setString(2,employee.getFname());
            statement.setString(3,employee.getLname());
            statement.setString(4,employee.getGender());
            statement.setString(5,employee.getDOB());
            statement.setString(6,employee.getNIC());
            statement.setDouble(7,employee.getBasicSalary());
            statement.setString(8,employee.getMobile());
            statement.setString(9,employee.getEmail());
            statement.setString(10,employee.getAddress());


            System.out.println(statement);
            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteEmployee(int employeeID)throws SQLException,ClassNotFoundException {
        Employee emp =null;
        boolean rowDeleted = false;
        try {

            con = DBConnectionUtil.getConnection();
            PreparedStatement statement = con.prepareStatement("delete from item_db.employee where employeeID=?");
            System.out.println(statement);

            statement.setInt(1,employeeID);

            // preparedStatement.execute();

            //use to update the query
            rowDeleted = statement.executeUpdate() > 0;//return number of rows deleted
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }




    public Employee viewEmployeeProfile(int ID) {

        Employee e1 = new Employee();
        try{
            con = com.rasa.util.DBConnectionUtil.getConnection();
            String sql ="select * from  item_db.employee where employeeID="+ID;
            preparedStatement = con.prepareStatement(sql);
            System.out.println(sql);

            ResultSet resultSet = preparedStatement.executeQuery();



            while(resultSet.next()) {
                e1.setEmployeeID(resultSet.getInt(1));
                e1.setFname(resultSet.getString(2));
                e1.setLname(resultSet.getString(3));
                e1.setGender(resultSet.getString(4));
                e1.setDOB(resultSet.getString(5));
                e1.setNIC(resultSet.getString(6));
                e1.setBasicSalary(resultSet.getDouble(7));
                e1.setMobile(resultSet.getString(8));
                e1.setEmail(resultSet.getString(9));
                e1.setAddress(resultSet.getString(10));

                System.out.println("service" + e1.getEmployeeID());

            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        return e1;
    }

    @Override
    public List<Employee> viewEmployeeDetails()throws SQLException {
        List<Employee> list = new ArrayList<>();
        try{
            con = com.rasa.util.DBConnectionUtil.getConnection();
            String sql ="select employeeID,fname from  item_db.employee";
            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int employeeID=Integer.parseInt(resultSet.getString("employeeID"));
                String fname=resultSet.getString("fname");

                Employee employee = new Employee(employeeID,fname);
                list.add(employee);
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        return list;
    }
    @Override
    public Employee load(String employeeID) {
        Employee emp = new Employee();

        try {
            con = DBConnectionUtil.getConnection();
            String sql ="select * from employee where employeeID="+employeeID;
            preparedStatement=con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(sql);


            while(resultSet.next()) {
                emp.setFname(resultSet.getString(2));
                emp.setLname(resultSet.getString(3));
                emp.setGender(resultSet.getString(4));
                emp.setDOB(resultSet.getString(5));
                emp.setNIC(resultSet.getString(6));
                emp.setBasicSalary(resultSet.getDouble(7));
                emp.setMobile(resultSet.getString(8));
                emp.setEmail(resultSet.getString(9));
                emp.setAddress(resultSet.getString(10));


            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return emp;

    }


    public   void employeeProfilePDF(int ID) throws IOException, DocumentException {


        Employee emp  =  viewEmployeeProfile(ID);
        //LocalDate date = LocalDate.now();
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\User\\reports\\emp" + ".pdf"));
        document.open();
        com.itextpdf.text.Font heading1 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 13, com.itextpdf.text.Font.BOLD, BaseColor.BLUE);
        com.itextpdf.text.Font heading2 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.NORMAL, BaseColor.BLUE);
        com.itextpdf.text.Font heading3 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
        int count =1;

        Chunk head = new Chunk("RASA MOTERS PRIVATE LIMITED", heading1);
        Chunk head3 = new Chunk("rasa moters", heading1);
        Chunk head2 = new Chunk("\n54/3 New Kandy Road ,Kotalawela,Kaduwela\nHotline:072323435\nemail:Rasa@gmail.com", heading2);

        //image path
        String path = "C:\\Users\\User\\Desktop\\KaviB hero here\\rasa.jpeg";
        com.itextpdf.text.Image img = Image.getInstance(path);
        PdfPTable table1 = new PdfPTable(2); // 3 columns.
        PdfPTable table2 = new PdfPTable(1); // 1 column

        Paragraph p1 = new Paragraph();
        p1.add(head);
        p1.add(head2);

        PdfPCell cella = new PdfPCell(img);
        PdfPCell cellb = new PdfPCell(p1);
        PdfPCell cellc = new PdfPCell(new Paragraph(head3));


        cella.setBorderWidth(0);
        cellb.setBorderWidth(0);
        cellc.setBorderWidth(0);
        cella.setFixedHeight(100);
        cellc.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table1.setWidthPercentage(100);
        table2.setWidthPercentage(200);

        table1.addCell(cella);
        table1.addCell(cellb);
        table2.addCell(cellc);
        document.add(table2);
        document.add(table1);
        document.add(table2);


        LocalDate date = LocalDate.now();
        Paragraph main = new Paragraph("Date  " + date);
        main.setSpacingAfter(40);
        document.add(main);

        PdfPTable table = new PdfPTable(2); // 3 columns.

        PdfPCell cell1 = new PdfPCell(new Paragraph("First Name"));
        PdfPCell cell2 = new PdfPCell(new Paragraph(emp.getFname()));
        PdfPCell cell3 = new PdfPCell(new Paragraph("Last Name"));
        PdfPCell cell4= new PdfPCell(new Paragraph(emp.getLname()));
        PdfPCell cell5 = new PdfPCell(new Paragraph("Gender"));
        PdfPCell cell6 = new PdfPCell(new Paragraph(emp.getGender()));
        PdfPCell cell7 = new PdfPCell(new Paragraph("Date of Birth"));
        PdfPCell cell8 = new PdfPCell(new Paragraph(emp.getDOB()));
        PdfPCell cell9 = new PdfPCell(new Paragraph("NIC"));
        PdfPCell cell10 = new PdfPCell(new Paragraph(emp.getNIC()));
        PdfPCell cell11 = new PdfPCell(new Paragraph("Basic Salary"));
        PdfPCell cell12 = new PdfPCell(new Paragraph(""+emp.getBasicSalary()));
        PdfPCell cell13 = new PdfPCell(new Paragraph("Email"));
        PdfPCell cell14 = new PdfPCell(new Paragraph(emp.getEmail()));
        PdfPCell cell15 = new PdfPCell(new Paragraph("mobile"));
        PdfPCell cell16 = new PdfPCell(new Paragraph(emp.getMobile()));
        PdfPCell cell17 = new PdfPCell(new Paragraph("Address"));
        PdfPCell cell18= new PdfPCell(new Paragraph(emp.getAddress()));




        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        table.addCell(cell5);
        table.addCell(cell6);
        table.addCell(cell7);
        table.addCell(cell8);
        table.addCell(cell9);
        table.addCell(cell10);
        table.addCell(cell11);
        table.addCell(cell12);
        table.addCell(cell13);
        table.addCell(cell14);
        table.addCell(cell15);
        table.addCell(cell16);
        table.addCell(cell17);
        table.addCell(cell18);






        document.add(table);
        document.close();
    }

}

