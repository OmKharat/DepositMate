package com.example.DepositManagement.Service;

import com.example.DepositManagement.Dto.DepositDTO;
import com.example.DepositManagement.Entity.Deposit;
import com.example.DepositManagement.Entity.User;

import java.util.List;

public interface DepositService {
    List<DepositDTO> getDepositsByUserId(User userId);
    Deposit createDeposit(User userId, DepositDTO depositDTO);
    List<DepositDTO> getAllDeposits();
    List<DepositDTO> getDepositsByType(String type);
}
