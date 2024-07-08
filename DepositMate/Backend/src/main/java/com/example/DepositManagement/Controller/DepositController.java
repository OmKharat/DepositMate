package com.example.DepositManagement.Controller;

import com.example.DepositManagement.Dto.DepositDTO;
import com.example.DepositManagement.Entity.Deposit;
import com.example.DepositManagement.Entity.User;
import com.example.DepositManagement.Service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/deposits")
@Service
public class DepositController {

    @Autowired
    private DepositService depositService;
    // Endpoint to create a new deposit
    @PostMapping("/{userId}/create")
    public ResponseEntity<DepositDTO> createDeposit(@PathVariable User userId,
                                                    @RequestBody DepositDTO depositDTO) {
        Deposit createdDeposit = depositService.createDeposit(userId, depositDTO);
        DepositDTO responseDTO = convertToDto(createdDeposit);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }



    @GetMapping("/all")
    public ResponseEntity<List<DepositDTO>> getAllDeposits() {
        List<DepositDTO> depositDTOs = depositService.getAllDeposits();
        return new ResponseEntity<>(depositDTOs, HttpStatus.OK);
    }


    // Endpoint to get deposits by user ID
    @GetMapping("/{userId}")
    public ResponseEntity<List<DepositDTO>> getDepositsByUserId(@PathVariable User userId) {
        List<DepositDTO> depositDTOs = depositService.getDepositsByUserId(userId);
        return new ResponseEntity<>(depositDTOs, HttpStatus.OK);
    }

    // Endpoint to get deposits by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<DepositDTO>> getDepositsByType(@PathVariable String type) {
        List<DepositDTO> depositDTOs = depositService.getDepositsByType(type);
        return new ResponseEntity<>(depositDTOs, HttpStatus.OK);
    }

    // Helper method to convert Entity to DTO
    private DepositDTO convertToDto(Deposit deposit) {
        DepositDTO depositDTO = new DepositDTO();
        depositDTO.setUserID(deposit.getUser());
        depositDTO.setDepositId(deposit.getId());
        depositDTO.setAmount(deposit.getAmount());
        depositDTO.setDepositType(deposit.getDepositType());
        depositDTO.setStartDate(deposit.getStartDate());
        depositDTO.setMaturityDate(deposit.getMaturityDate());
        depositDTO.setNoOfYears(deposit.getNoOfYears());
        depositDTO.setInterestRate(deposit.getInterestRate().doubleValue());
        return depositDTO;
    }
}
