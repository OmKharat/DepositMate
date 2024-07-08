package com.example.DepositManagement.Dto;

import jakarta.persistence.Column;

public class UserDTO {
    private int userid;
    private String username;
    private int age;
    private String gender;
    private String phonenumber;
    private String email;
    private String aadhar;
    private String password;

    public UserDTO(int userid, String username, int age, String gender, String phonenumber, String email, String aadhar, String password) {
        this.userid = userid;
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.phonenumber = phonenumber;
        this.email = email;
        this.aadhar = aadhar;
        this.password = password;
    }
    public UserDTO(){

    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", aadhar='" + aadhar + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
