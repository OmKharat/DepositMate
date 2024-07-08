package com.example.DepositManagement.Service.impl;

import com.example.DepositManagement.Dto.LoginDTO;
import com.example.DepositManagement.Dto.UserDTO;
import com.example.DepositManagement.Entity.User;
import com.example.DepositManagement.Repo.UserRepo;
import com.example.DepositManagement.Service.UserService;
import com.example.DepositManagement.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo userRepo;

    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
            userDTO.getUserid(),
            userDTO.getUsername(),
            userDTO.getAge(),
            userDTO.getGender(),
            userDTO.getPhonenumber(),
            userDTO.getEmail(),
            userDTO.getAadhar(),
            this.passwordEncoder.encode(userDTO.getPassword())
        );
        userRepo.save(user);
        return user.getUsername();

    }
    UserDTO userDTO;

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true, user1.getUserid());
                } else {
                    return new LoginResponse("Login Failed", false,-1);
                }
            } else {
                return new LoginResponse("Password Not Match", false,-1);
            }
        } else {
            return new LoginResponse("Email not exists", false,-1);
        }
    }


}
