package com.example.DepositManagement.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "deposits")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "deposit_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "maturity_date")
    private Date maturityDate;

    @Column(name = "deposit_type")
    private String depositType;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "no_of_years")
    private int noOfYears;

    public Deposit() {
    }

    public Deposit(User user, Double amount, Date startDate, Date maturityDate, String depositType, BigDecimal interestRate, int noOfYears) {
        this.user = user;
        this.amount = amount;
        this.startDate = startDate;
        this.maturityDate = maturityDate;
        this.depositType = depositType;
        this.interestRate = interestRate;
        this.noOfYears = noOfYears;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public int getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }
}
