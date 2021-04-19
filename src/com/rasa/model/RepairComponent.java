package com.rasa.model;

public class RepairComponent {
    private RepairService repairService;
    private int estimateAmount;
    private VehicleComponent vehicleComponent;

    public RepairComponent() {
    }

    public RepairComponent(RepairService repairService, int estimateAmount, VehicleComponent vehicleComponent) {
        this.repairService = repairService;
        this.estimateAmount = estimateAmount;
        this.vehicleComponent = vehicleComponent;
    }

    public RepairService getRepairService() {
        return repairService;
    }

    public void setRepairService(RepairService repairService) {
        this.repairService = repairService;
    }

    public int getEstimateAmount() {
        return estimateAmount;
    }

    public void setEstimateAmount(int estimateAmount) {
        this.estimateAmount = estimateAmount;
    }

    public VehicleComponent getVehicleComponent() {
        return vehicleComponent;
    }

    public void setVehicleComponent(VehicleComponent vehicleComponent) {
        this.vehicleComponent = vehicleComponent;
    }
}
