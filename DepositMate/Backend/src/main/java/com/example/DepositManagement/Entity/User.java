package com.example.DepositManagement.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false, length = 255)
    private int userid;

    @Column(name = "user_name", nullable = false, length = 255)
    private String username;

    @Column(name = "age", nullable = false, length = 255)
    private int age;

    @Column(name = "gender", nullable = false, length = 255)
    private String gender;

    @Column(name = "phone_number", nullable = false, length = 255)
    private String phonenumber;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "aadhar", nullable = false, length = 255)
    private String aadhar;

    @Column(name = "password", nullable = false, length = 255)
    private String password;



    public User(int userid, String username, int age, String gender, String phonenumber, String email, String aadhar, String password) {
        this.userid = userid;
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.phonenumber = phonenumber;
        this.email = email;
        this.aadhar = aadhar;
        this.password = password;
    }
    public User(){
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
        return "User{" +
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
