package com.rasa.service;

import com.rasa.model.Item;
import com.rasa.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InventoryService implements Iinventory{


  //get item name from inventory
    public ArrayList<String> getItemName() throws SQLException, ClassNotFoundException {
         Connection con = DBConnectionUtil.getConnection();
         ArrayList<String> list = new ArrayList<>();
         String sql = "select itemName from inventory";

         PreparedStatement preparedStatement = con.prepareStatement(sql);
         ResultSet ItemList = preparedStatement.executeQuery();

         while(ItemList.next()){
             list.add(ItemList.getString(1));
         }



         return list;
    }
    //data retrive select query
    public ArrayList<String> getSupplerName() throws SQLException, ClassNotFoundException {
        Connection con = DBConnectionUtil.getConnection();
        ArrayList<String> Slist = new ArrayList<>();
        String sql = "select supplierName from supplier";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet ItemList = preparedStatement.executeQuery();

        while(ItemList.next()){
            Slist.add(ItemList.getString(1));
        }
        return Slist;

    }
    //data Insert  query
    @Override
    public Boolean AddItem(Item item) throws SQLException, ClassNotFoundException {

        String supId = getSupplerID(item.getsupplyName());
        String ItemCodes = getItemCode(item.getItemName());
        Item items = getItemfromId(ItemCodes,item.getDate(),supId);

        if(items.getDate()!= null){
            return true;

        }


        String ItemCode = null;
        String SupplerId = null;
        int Icount = 0;
        int TotalCount = 0;
        Connection con = DBConnectionUtil.getConnection();
        String sqlItem = "Insert into item (itemCode, itemName, supplierID, price, quntity, date) values(?,?,?,?,?,?)";
        String sqlgetItemCode = "Select itemCode , icount from inventory where itemName = ?";
        String SqlgetSupplyId = "select supplierID from supplier where supplierName = ?";
        String UpdateCount = "UPDATE inventory SET icount = ? WHERE  itemName = ? ";

        PreparedStatement p1 = con.prepareStatement(SqlgetSupplyId);
        PreparedStatement p2 = con.prepareStatement(sqlgetItemCode);
        PreparedStatement p3 = con.prepareStatement(sqlItem);
        PreparedStatement p4 = con.prepareStatement(UpdateCount);

        p2.setString(1,item.getItemName());
        p1.setString(1,item.getsupplyName());

        ResultSet resultSet1 = p1.executeQuery();
        ResultSet resultSet2 = p2.executeQuery();



        while (resultSet1.next()){
            SupplerId = resultSet1.getString(1);
        }
        while (resultSet2.next()){
            ItemCode = resultSet2.getString(1);
            Icount = resultSet2.getInt(2);

        }
        //update quntity
        TotalCount = item.getQuantity()+Icount;
        System.out.println(TotalCount);
        p4.setInt(1,TotalCount);
        p4.setString(2,item.getItemName());
        p4.executeUpdate();

        p3.setString(1,ItemCode);
        p3.setString(2,item.getItemName());
        p3.setString(3,SupplerId);
        p3.setDouble(4,item.getPrice());
        p3.setInt(5,item.getQuantity());
        p3.setString(6,item.getDate());

        Boolean res = p3.execute();



        return res;
    }
   //select query for retrive data
    @Override
    public ArrayList<Item> retriveAllItemList() throws SQLException, ClassNotFoundException {

        Connection con = DBConnectionUtil.getConnection();
        ArrayList<Item> ItemList = new ArrayList<>();
        String queryR = "select itemCode, itemName, supplierID, price, quntity, date from item";

        PreparedStatement preparedStatement = con.prepareStatement(queryR);

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Item item = new Item();
            item.setItemCode(resultSet.getString(1));
            item.setItemName(resultSet.getString(2));
            item.setSupplerName(resultSet.getString(3));
            item.setPrice(resultSet.getDouble(4));
            item.setQuantity(resultSet.getInt(5));
            item.setDate(resultSet.getString(6));
            ItemList.add(item);
        }
        return ItemList;
    }
   //update query for update price and quntity
    @Override
    public boolean updateItem(Item item) throws SQLException, ClassNotFoundException {

        String ItemCodes = getItemCode(item.getItemName());

        Connection con = DBConnectionUtil.getConnection();
        String updateSql = "UPDATE item  SET `price` = ?,`quntity` =?  WHERE `itemCode` =? AND `supplierID` = ? AND `date` = ?";
        PreparedStatement preparedStatement = con.prepareStatement(updateSql);


        preparedStatement.setDouble(1,item.getPrice());
        preparedStatement.setInt(2,item.getQuantity());
        preparedStatement.setString(3,ItemCodes);
        preparedStatement.setInt(4,item.getSupplerID());
        preparedStatement.setString(5,item.getDate());

        int r = preparedStatement.executeUpdate();

        if(r == 1){
            return true;
        }
        else{
            return false;
        }

    }
  //getIdtem Id
    @Override
    public Item getItemfromId(String itemcode,String date, String supplerID) throws SQLException, ClassNotFoundException {
        Item I = new Item();
        Connection con = DBConnectionUtil.getConnection();
        String queryItemCodes = "select itemCode, itemName, supplierID, price, quntity, date from item where itemCode = ? And supplierID = ? AND date = ?";
        PreparedStatement preparedStatement = con.prepareStatement(queryItemCodes);
        preparedStatement.setString(1,itemcode);
        preparedStatement.setString(2,supplerID);
        preparedStatement.setString(3,date);

        ResultSet resultSet =  preparedStatement.executeQuery();

        while (resultSet.next()){

               I.setItemCode(resultSet.getString(1));
               I.setItemName(resultSet.getString(2));
               I.setSupplerName(resultSet.getString(3));
               I.setPrice(resultSet.getDouble(4));
               I.setQuantity(resultSet.getInt(5));
               I.setDate(resultSet.getString(6));

        }

        return I;

    }
    //getsupplerID
    public String getSupplerID(String sname) throws SQLException, ClassNotFoundException {
        Connection con = DBConnectionUtil.getConnection();
        String supId = null;
        String sql = "SELECT supplierID FROM supplier where supplierName = ?";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,sname);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){
            supId = rs.getString(1);
        }

        return  supId;

    }
    public String getItemCode(String Iname) throws SQLException, ClassNotFoundException {
           Connection con = DBConnectionUtil.getConnection();
           String ItemCodes =null;
           String selectId  = "SELECT itemCode FROM rasa.inventory where itemName = ?";

           PreparedStatement preparedStatement = con.prepareStatement(selectId);
           preparedStatement.setString(1,Iname);

           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()){
               ItemCodes = rs.getString(1);
           }
           return ItemCodes;

    }


}
