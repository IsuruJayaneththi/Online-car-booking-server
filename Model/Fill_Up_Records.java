package com.example.issa.pdm_project_2018_server.Model;

public class Fill_Up_Records {

    private String Vehiclename;
    private String Filledlocation;
    private String Startmeter;
    private String Endmeter;
    private String Cost;
    private String Noofliter;
    private String Phone;
    private String Name;
    private String status;

    public Fill_Up_Records() {
    }

    public Fill_Up_Records(String vehiclename, String filledlocation, String startmeter, String endmeter, String cost, String noofliter, String phone, String name, String status) {
        Vehiclename = vehiclename;
        Filledlocation = filledlocation;
        Startmeter = startmeter;
        Endmeter = endmeter;
        Cost = cost;
        Noofliter = noofliter;
        Phone = phone;
        Name = name;
        this.status = "0";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVehiclename() {
        return Vehiclename;
    }

    public void setVehiclename(String vehiclename) {
        Vehiclename = vehiclename;
    }

    public String getFilledlocation() {
        return Filledlocation;
    }

    public void setFilledlocation(String filledlocation) {
        Filledlocation = filledlocation;
    }

    public String getStartmeter() {
        return Startmeter;
    }

    public void setStartmeter(String startmeter) {
        Startmeter = startmeter;
    }

    public String getEndmeter() {
        return Endmeter;
    }

    public void setEndmeter(String endmeter) {
        Endmeter = endmeter;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getNoofliter() {
        return Noofliter;
    }

    public void setNoofliter(String noofliter) {
        Noofliter = noofliter;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
