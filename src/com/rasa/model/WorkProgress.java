package com.rasa.model;

public class WorkProgress {
    private String pid;
    private int sid;
    private double tot_EstimateAmount;

    public WorkProgress() {
    }

    public WorkProgress(String pid, int sid, double tot_EstimateAmount) {
        this.pid = pid;
        this.sid = sid;
        this.tot_EstimateAmount = tot_EstimateAmount;
    }

    public WorkProgress(String pid, int sid) {
        this.pid = pid;
        this.sid = sid;
    }

    public String getPid() {
        return pid;
    }

    public int getSid() {
        return sid;
    }

    public double getTot_EstimateAmount() {
        return tot_EstimateAmount;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setTot_EstimateAmount(double tot_EstimateAmount) {
        this.tot_EstimateAmount = tot_EstimateAmount;
    }
}
