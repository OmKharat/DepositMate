package com.example.DepositManagement.Service.impl;

import com.example.DepositManagement.Dto.DepositDTO;
import com.example.DepositManagement.Entity.Deposit;
import com.example.DepositManagement.Entity.User;
import com.example.DepositManagement.Repo.DepositRepository;
import com.example.DepositManagement.Service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepositServiceImpl implements DepositService {

    @Autowired
    private DepositRepository depositRepository;

    @Override
    public List<DepositDTO> getDepositsByUserId(User userId) {
        List<Deposit> deposits = depositRepository.findByUser(userId);
        return deposits.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    public Deposit createDeposit(User userId, DepositDTO depositDTO) {
        // Convert start date from java.util.Date to java.sql.Date
        Date startDate = new Date(depositDTO.getStartDate().getTime());
        int noOfYears = depositDTO.getNoOfYears();

        // Calculate maturity date based on start date and number of years
        Date maturityDate = calculateMaturityDate(startDate, noOfYears);

        // Determine interest percentage based on deposit type
        BigDecimal interestRate = BigDecimal.ZERO;
        String depositType = depositDTO.getDepositType();
        switch (depositType) {
            case "Fixed Deposit":
                interestRate = new BigDecimal("6");
                break;
            case "Recurrent Deposit":
                interestRate = new BigDecimal("5");
                break;
            case "Cumulative Deposit":
                interestRate = new BigDecimal("7");
                break;
            default:
                // Handle unknown deposit types or throw an exception
                throw new IllegalArgumentException("Invalid deposit type: " + depositType);
        }
        
        Deposit deposit = new Deposit();
        deposit.setUser(userId);
        deposit.setAmount(depositDTO.getAmount());
        deposit.setDepositType(depositType);
        deposit.setStartDate(startDate);
        deposit.setNoOfYears(noOfYears);
        deposit.setMaturityDate(maturityDate);
        deposit.setInterestRate(interestRate);

        // Save deposit entity to repository
        return depositRepository.save(deposit);
    }

    private Date calculateMaturityDate(Date startDate, int noOfYears) {
        // Calculate maturity date based on start date and number of years
        long msInYear = 1000L * 60 * 60 * 24 * 365;
        long maturityTime = startDate.getTime() + noOfYears * msInYear;
        return new Date(maturityTime);
    }





    @Override
    public List<DepositDTO> getAllDeposits() {
        List<Deposit> deposits = depositRepository.findAll();
        return deposits.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DepositDTO> getDepositsByType(String type) {
        List<Deposit> deposits = depositRepository.findByDepositType(type);
        return deposits.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Helper method to convert Entity to DTO
    private DepositDTO convertToDto(Deposit deposit) {
        DepositDTO depositDTO = new DepositDTO();
        depositDTO.setUserID(deposit.getUser());
        depositDTO.setDepositId(deposit.getId());
        depositDTO.setAmount(deposit.getAmount());
        depositDTO.setDepositType(deposit.getDepositType());
        depositDTO.setStartDate(new java.util.Date(deposit.getStartDate().getTime()));
        depositDTO.setMaturityDate(new java.util.Date(deposit.getMaturityDate().getTime()));
        depositDTO.setNoOfYears(deposit.getNoOfYears());
        depositDTO.setInterestRate(deposit.getInterestRate().doubleValue());
        return depositDTO;
    }
}
