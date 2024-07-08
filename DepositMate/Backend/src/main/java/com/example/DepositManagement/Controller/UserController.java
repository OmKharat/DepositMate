package com.example.DepositManagement.Controller;

import com.example.DepositManagement.Dto.LoginDTO;
import com.example.DepositManagement.Dto.UserDTO;
import com.example.DepositManagement.Service.UserService;
import com.example.DepositManagement.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/user")
public class UserController {
   @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String SaveUser(@RequestBody UserDTO userDTO)
    {
        String id = userService.addUser(userDTO);

        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }


}
