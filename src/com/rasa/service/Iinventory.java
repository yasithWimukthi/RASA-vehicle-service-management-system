package com.rasa.service;

import com.rasa.model.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Iinventory {
    public ArrayList<String> getItemName() throws SQLException, ClassNotFoundException;
    public ArrayList<String> getSupplerName() throws SQLException, ClassNotFoundException;
    public Boolean AddItem(Item item) throws SQLException, ClassNotFoundException;
    public ArrayList<Item> retriveAllItemList() throws SQLException, ClassNotFoundException;
    public boolean updateItem(Item item) throws SQLException, ClassNotFoundException;
    public Item getItemfromId(String itemcode,String date, String supplerID) throws SQLException, ClassNotFoundException;

}
