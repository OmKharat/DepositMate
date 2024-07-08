package com.example.DepositManagement.response;

public class LoginResponse {
    String message;
    Boolean status;
    int userid;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Boolean getStatus() {
        return status;
    }
    public int getUserid(){
        return userid;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public LoginResponse(String message, Boolean status, int userid) {
        this.message = message;
        this.status = status;
        this.userid = userid;
    }
}
