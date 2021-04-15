package com.rasa.model;

public class VehicleComponent {
    private String V_itemId;
    private String V_Item_name;

    public VehicleComponent() {
    }

    public VehicleComponent(String v_itemId, String v_Item_name) {
        V_itemId = v_itemId;
        V_Item_name = v_Item_name;
    }

    public String getV_itemId() {
        return V_itemId;
    }

    public String getV_Item_name() {
        return V_Item_name;
    }

    public void setV_itemId(String v_itemId) {
        V_itemId = v_itemId;
    }

    public void setV_Item_name(String v_Item_name) {
        V_Item_name = v_Item_name;
    }
}
