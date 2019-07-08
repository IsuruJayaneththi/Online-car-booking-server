package com.example.issa.pdm_project_2018_server.Model;

import java.util.List;

public class Request {

    //Add new state payment


    private String phone;
    private String name;
    private String address;
    private String total;
    private String status;
    private String date;
    private String time;
    private String paymentState;
    private List<Order> cars; //list of car order


    public Request() {
    }

    public Request(String phone, String name, String address, String total, String status, String date, String time, String paymentState, List<Order> cars) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.total = total;
        this.status = "0";
        this.date = date;
        this.time = time;
        this.paymentState = paymentState;
        this.cars = cars;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    public List<Order> getCars() {
        return cars;
    }

    public void setCars(List<Order> cars) {
        this.cars = cars;
    }
}
