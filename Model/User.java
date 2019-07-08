package com.example.issa.pdm_project_2018_server.Model;

public class User {

    private String Password;
    private String Age;
    private String Email;
    private String Name;
    private String IsStaff;
    private String Phone;

    public User() {
    }

    public User(String password, String age, String email, String name) {
        Password = password;
        Age = age;
        Email = email;
        Name = name;
        IsStaff = "true";
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}


