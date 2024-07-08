package com.example.DepositManagement.Service;

import com.example.DepositManagement.Dto.LoginDTO;
import com.example.DepositManagement.Dto.UserDTO;
import com.example.DepositManagement.response.LoginResponse;

public interface UserService {
    String addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
}
