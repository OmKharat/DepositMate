package com.example.DepositManagement.Dto;

import com.example.DepositManagement.Entity.User;

import java.math.BigDecimal;
import java.util.Date;

public class DepositDTO {
    private int depositID;
    private User userID;
    private Double amount;
    private int noOfYears;
    private Date startDate;
    private Date maturityDate;
    private String depositType;
    private BigDecimal interestRate;

    public DepositDTO() {

    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public int getDepositId() {
        return depositID;
    }

    public void setDepositId(int depositID) {
        this.depositID = depositID;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = BigDecimal.valueOf(interestRate);
    }

    public int getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }

    public DepositDTO(int depositID, User userID, Double amount, int noOfYears, Date startDate, Date maturityDate, String depositType, BigDecimal interestRate) {
        this.depositID = depositID;
        this.userID = userID;
        this.amount = amount;
        this.noOfYears = noOfYears;
        this.startDate = startDate;
        this.maturityDate = maturityDate;
        this.depositType = depositType;
        this.interestRate = interestRate;
    }
}
