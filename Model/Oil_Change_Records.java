package com.example.issa.pdm_project_2018_server.Model;

public class Oil_Change_Records {

    private String Oiltype;
    private String Location;
    private String Amount;
    private String Billno;
    private String Time;
    private String Date;
    private String Phone;
    private String Name;
    private String status;


    public Oil_Change_Records() {
    }

    public Oil_Change_Records(String oiltype, String location, String amount, String billno, String time, String date, String phone, String name, String status) {
        this.Oiltype = oiltype;
        this.Location = location;
        this.Amount = amount;
        this.Billno = billno;
        this.Time = time;
        this.Date = date;
        this.Phone = phone;
        this.Name = name;
        this.status = "0";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOiltype() {
        return Oiltype;
    }

    public void setOiltype(String oiltype) {
        Oiltype = oiltype;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getBillno() {
        return Billno;
    }

    public void setBillno(String billno) {
        Billno = billno;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
