package com.rasa.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rasa.model.RepairComponent;
import com.rasa.model.RepairService;
import com.rasa.model.VehicleComponent;
import com.rasa.util.DBConnectionUtil;

import javax.print.Doc;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Workprogress_service implements Iworkprogress_service{

    Connection con = null;
    @Override
    public String getProgressId(int sid) throws SQLException, ClassNotFoundException {
        //initialized pid
        String pid = null;
        con = DBConnectionUtil.getConnection();
        String sql = "Select pid from workprogress where sid = ? ";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,sid);

        ResultSet S_pid = preparedStatement.executeQuery();
        while(S_pid.next()){
            pid = S_pid.getString(1);

        }
        return pid;
    }

    @Override
    public String createProgressId(int sid) {
        return "PID"+sid;
    }

    @Override
    public String createServiceId(String pid,String type) {
        return pid + type.substring(1,4);
    }

    @Override
    public boolean Createprogress(int sid) throws SQLException, ClassNotFoundException {
        String pid = this.createProgressId(sid);
        //if user refresh page twice page will redirect to the add_service.jsp
        if(getProgressId(sid) != null){
            return true;
        }
        //if it was not create pid
        con = DBConnectionUtil.getConnection();
        String sql = "INSERT INTO `workprogress`(`pid`,`sid`) VALUES (?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);

        preparedStatement.setString(1,pid);
        preparedStatement.setInt(2,sid);

        Boolean isCreate = preparedStatement.execute();
        return isCreate;


    }

    //insert function
    @Override
    public Boolean InsertService(RepairService repairService) throws SQLException, ClassNotFoundException {
        //create serviceID and return ID

        String ser_id = this.createServiceId(repairService.getPid(),repairService.getSer_type());
        //check weather already added services
        if(this.retirvedatabyID(ser_id).getSer_Id()!= null){

            return true;
        }

        con = DBConnectionUtil.getConnection();
        String sqlInsert ="INSERT INTO `repair_service`(`ser_id`, `ser_type`, `description`, `status`, `s_date`, `pid`) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sqlInsert);
        preparedStatement.setString(1,ser_id);
        preparedStatement.setString(2,repairService.getSer_type());
        preparedStatement.setString(3,repairService.getDescription());
        preparedStatement.setString(4,repairService.getStatus());
        preparedStatement.setString(5,repairService.getDate());
        preparedStatement.setString(6,repairService.getPid());

        Boolean Is_add = preparedStatement.execute();
        return Is_add;

    }

    @Override
    public ArrayList<RepairService> displayServicelist(String pid) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        ArrayList<RepairService> rList = new ArrayList<>();
        String selecQuery = "SELECT `ser_id`, `ser_type`, `description`, `status`, `s_date` FROM `repair_service` WHERE pid = ?";

        PreparedStatement preparedStatement = con.prepareStatement(selecQuery);
        preparedStatement.setString(1,pid);

        ResultSet listService = preparedStatement.executeQuery();

        while(listService.next()){
            RepairService repairService = new RepairService();
            repairService.setSer_Id(listService.getString(1));
            repairService.setSer_type(listService.getString(2));
            repairService.setDescription(listService.getString(3));
            repairService.setStatus(listService.getString(4));
            repairService.setDate(listService.getString(5));

            rList.add(repairService);

        }
        return rList;
    }

    @Override
    public RepairService retirvedatabyID(String ser_id) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        String getdatabyId = "SELECT `ser_id`, `ser_type`, `description`, `status`, `s_date` FROM `repair_service` WHERE ser_id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(getdatabyId);
        preparedStatement.setString(1,ser_id);

        ResultSet ser_recd = preparedStatement.executeQuery();
        RepairService r1 = new RepairService();
        while (ser_recd.next()){
            r1.setSer_Id(ser_recd.getString(1));
            r1.setSer_type(ser_recd.getString(2));
            r1.setDescription(ser_recd.getString(3));
            r1.setStatus(ser_recd.getString(4));
            r1.setDate(ser_recd.getString(5));
        }
        return r1;


    }

    @Override
    public boolean updateServiceStatus(RepairService repairService) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        String updateQuery = "UPDATE `repair_service` SET `description`=? ,`status`= ? WHERE `ser_id` = ?";
        PreparedStatement preparedStatement = con.prepareStatement(updateQuery);
        preparedStatement.setString(1,repairService.getDescription());
        preparedStatement.setString(2,repairService.getStatus());
        preparedStatement.setString(3,repairService.getSer_Id());
        int res = preparedStatement.executeUpdate();
        if(res==1)
            return true;
        else
            return false;

    }

    @Override
    public Boolean addRepairComponent(RepairComponent repairComponent) throws SQLException, ClassNotFoundException {
        //check dublicate elements
        if(this.retriveRepairComponentById(repairComponent.getRepairService().getSer_Id(),repairComponent.getVehicleComponent().getV_itemId(),"") != null){
            return true;
        }

        con = DBConnectionUtil.getConnection();
        String insertQuery = "INSERT INTO `vehiclerepair_item`(`ser_id`, `ItemId`, `estimateAmount`) VALUES (?,?,?)";

        PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
        preparedStatement.setString(1,repairComponent.getRepairService().getSer_Id());
        preparedStatement.setString(2,repairComponent.getVehicleComponent().getV_itemId());
        preparedStatement.setInt(3,repairComponent.getEstimateAmount());

        Boolean res = preparedStatement.execute();

        return res;
    }

    @Override
    public ArrayList<RepairComponent> retriveRepairComponents(String ser_id) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        ArrayList<RepairComponent> List_repair_com = new ArrayList<>();
        String retrive_comp_query = "SELECT ve.ser_id , ve.ItemId , ve.estimateAmount , r.ItemName FROM vehiclerepair_item ve , repairitem r WHERE r.ItemId = ve.ItemId AND ve.ser_id =?";
        PreparedStatement preparedStatement = con.prepareStatement(retrive_comp_query);

        preparedStatement.setString(1,ser_id);
        ResultSet listRepairC = preparedStatement.executeQuery();

        while(listRepairC.next()){
            RepairComponent repairComponent = new RepairComponent();
            RepairService repairService = new RepairService();
            VehicleComponent vehicleComponent = new VehicleComponent();

            String serId = listRepairC.getString(1);
            String ItemId = listRepairC.getString(2);
            int estimateA = listRepairC.getInt(3);
            String ItemName = listRepairC.getString(4);

            repairService.setSer_Id(serId);
            vehicleComponent.setV_itemId(ItemId);
            vehicleComponent.setV_Item_name(ItemName);

            repairComponent.setRepairService(repairService);
            repairComponent.setVehicleComponent(vehicleComponent);
            repairComponent.setEstimateAmount(estimateA);


            List_repair_com.add(repairComponent);

        }

        return List_repair_com;
    }

    @Override
    public ArrayList<VehicleComponent> retriveVehcileComponents() throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        ArrayList<VehicleComponent> list_Vehicle_Com = new ArrayList<>();
        String getVehcileComQuery = "SELECT `ItemId`, `ItemName` FROM `repairitem`";
        PreparedStatement preparedStatement = con.prepareStatement(getVehcileComQuery);
        ResultSet ListVehicleComponents =  preparedStatement.executeQuery();
        while (ListVehicleComponents.next()){
             VehicleComponent vehicleComponent = new VehicleComponent(
                     ListVehicleComponents.getString(1),
                     ListVehicleComponents.getString(2)
             );
             list_Vehicle_Com.add(vehicleComponent);


        }


        return list_Vehicle_Com;
    }

    @Override
    public RepairComponent retriveRepairComponentById(String ser_id,String Item_id,String s_name) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        RepairComponent repairComponent = null;
        String VehicleComponentQuery = "SELECT `ser_id`, `ItemId`, `estimateAmount` FROM `vehiclerepair_item` WHERE ser_id = ? AND ItemId = ?";
        PreparedStatement preparedStatement = con.prepareStatement(VehicleComponentQuery);
        preparedStatement.setString(1,ser_id);
        preparedStatement.setString(2,Item_id);

        ResultSet ObjectVehicleComponent = preparedStatement.executeQuery();

        while (ObjectVehicleComponent.next()){
            VehicleComponent vehicleComponent = new VehicleComponent();
            RepairService repairService = new RepairService();

            repairService.setSer_Id(ObjectVehicleComponent.getString(1));
            vehicleComponent.setV_itemId(ObjectVehicleComponent.getString(2));
            vehicleComponent.setV_Item_name(s_name);

            repairComponent = new RepairComponent(
                    repairService,
                    ObjectVehicleComponent.getInt(3),
                    vehicleComponent
                    );
        }
        return repairComponent;
    }

    @Override
    public Boolean UpdateRepairComponent(String ser_id , String item_id , int estimateA) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();

        String UpdateVehicleComponentQ = "UPDATE `vehiclerepair_item` SET `estimateAmount`= ? WHERE ser_id= ? AND ItemId =?";
        PreparedStatement preparedStatement = con.prepareStatement(UpdateVehicleComponentQ);
        preparedStatement.setInt(1,estimateA);
        preparedStatement.setString(2,ser_id);
        preparedStatement.setString(3,item_id);

        int res = preparedStatement.executeUpdate();
        if(res == 1)
            return true;
        else
            return false;

    }

    @Override
    public Boolean deleteRepairComponent(String ser_id, String item_id) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        String deleteQuery = "DELETE FROM `vehiclerepair_item` WHERE ser_id = ? AND ItemId = ?";
        PreparedStatement preparedStatement = con.prepareStatement(deleteQuery);

        preparedStatement.setString(1,ser_id);
        preparedStatement.setString(2,item_id);
        Boolean res = preparedStatement.execute();
        System.out.println(res);
        return res;
    }

    public double CalcTotalEstimates(String type , int sid) throws SQLException, ClassNotFoundException {
        con = DBConnectionUtil.getConnection();
        double Totalestimate = 0.0;
        double Eamount = 0.0;

        String query = "SELECT vi.estimateAmount FROM  workprogress w , repair_service rs , vehiclerepair_item vi WHERE  w.pid = rs.pid AND rs.ser_id = vi.ser_id AND w.sid = ? AND rs.ser_type =?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1,sid);
        preparedStatement.setString(2,type);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Eamount= resultSet.getDouble(1);
            Totalestimate = Totalestimate +Eamount;
        }

        return Totalestimate;

    }

    @Override
    public boolean createEstimatePdf(ArrayList<RepairService> repairServices) throws IOException, DocumentException, SQLException, ClassNotFoundException {
        //date
        LocalDate date = LocalDate.now();

        Document document = new Document();
        //pdf path
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\USER\\Desktop\\reports\\estimate"+date+".pdf"));
        document.open();
        //header part
        //font
        Font heading1 = new Font(Font.FontFamily.HELVETICA,13,Font.BOLD,BaseColor.BLUE);
        Font heading2 = new Font(Font.FontFamily.HELVETICA,12,Font.NORMAL,BaseColor.BLUE);

        Chunk head = new Chunk("RASA MOTERS PRIVATE LIMITED",heading1);
        Chunk head3 = new Chunk("rasa moters",heading1);
        Chunk head2 = new Chunk("54/3 New Kandy Road ,Kotalawela,Kaduwela\nHotline:072323435\nemail:Rasa@gmail.com",heading2);

        //image path
        String path = "C:\\Users\\USER\\Desktop\\reports\\rasa.jpg";

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

        //body for estimate tables
        Iworkprogress_service iworkprogress_service = new Workprogress_service();
        Paragraph headingEstimate = new Paragraph("Estimate Report "+ date);
        Paragraph VehicleNo = new Paragraph("Vehicle No "+ "1000D");
        Paragraph space2 = new Paragraph(" ");
        document.add(headingEstimate);
        document.add(VehicleNo);
        document.add(space2);

        PdfPCell namec = new PdfPCell(new Paragraph("Repair Component"));
        PdfPCell estimateA = new PdfPCell(new Paragraph("Estimate Amount"));
        PdfPTable pTable = new PdfPTable(2);

        pTable.addCell(namec);
        pTable.addCell(estimateA);


        for(RepairService rs : repairServices){
              Paragraph paragraph = new Paragraph(rs.getSer_type());
              Paragraph space = new Paragraph(" ");
              document.add(paragraph);
              document.add(space);
              ArrayList<RepairComponent> rpc = iworkprogress_service.retriveRepairComponents(rs.getSer_Id());

            for(RepairComponent rp : rpc){
                PdfPCell pdfPCell1 = new PdfPCell(new Paragraph(rp.getVehicleComponent().getV_Item_name()));
                PdfPCell pdfPCell2 = new PdfPCell(new Paragraph("Rs :"+rp.getEstimateAmount()));

                pTable.addCell(pdfPCell1);
                pTable.addCell(pdfPCell2);


            }
            document.add(pTable);
            pTable.deleteBodyRows();
            rpc.clear();


        }
        document.close();


        //body end
        return true;
    }


}
