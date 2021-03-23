package com.rasa.model;

public class WorkProgress {
    private String pid;
    private double estimateAmount;
    private int sid;

    public WorkProgress() {
    }

    public WorkProgress(String pid, double estimateAmount, int sid) {
        this.pid = pid;
        this.estimateAmount = estimateAmount;
        this.sid = sid;
    }

    public String getPid() {
        return pid;
    }

    public double getEstimateAmount() {
        return estimateAmount;
    }

    public int getSid() {
        return sid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setEstimateAmount(double estimateAmount) {
        this.estimateAmount = estimateAmount;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
