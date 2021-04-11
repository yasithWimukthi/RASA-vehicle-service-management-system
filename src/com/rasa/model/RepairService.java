package com.rasa.model;

public class RepairService {

    private String Ser_Id;
    private String ser_type;
    private String description;
    private String date;
    private String Status;
    private String pid;

    public RepairService() {
    }

    public RepairService(String ser_Id, String ser_type, String description, String date, String status, String pid) {
        Ser_Id = ser_Id;
        this.ser_type = ser_type;
        this.description = description;
        this.date = date;
        Status = status;
        this.pid = pid;
    }

    public RepairService(String ser_type, String description, String date, String status, String pid) {
        this.ser_type = ser_type;
        this.description = description;
        this.date = date;
        Status = status;
        this.pid = pid;
    }

    public void setSer_Id(String ser_Id) {
        Ser_Id = ser_Id;
    }

    public void setSer_type(String ser_type) {
        this.ser_type = ser_type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSer_Id() {
        return Ser_Id;
    }

    public String getSer_type() {
        return ser_type;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return Status;
    }

    public String getPid() {
        return pid;
    }

    @Override
    public String toString() {
        return "WorkService{" +
                "Ser_Id='" + Ser_Id + '\'' +
                ", ser_type='" + ser_type + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", Status='" + Status + '\'' +
                ", pid='" + pid + '\'' +
                '}';
    }
}
