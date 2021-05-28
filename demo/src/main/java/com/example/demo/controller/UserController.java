package com.example.demo.controller;

import com.example.demo.Interface.UserInterface;
//import com.example.demo.connection.Connection_Bean;
import com.example.demo.controller.requests.LoginRequest;
import com.example.demo.controller.requests.RegisterRequest;
import com.example.demo.controller.response.UserResponse;
import com.example.demo.model.UserEntity;
import com.example.demo.services.UserServices;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping(value = "/index")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping(value = "/login")
    public UserResponse login(@RequestBody LoginRequest loginRequest) throws SQLException {
        return userServices.login(loginRequest);
    }

    @PostMapping(value = "/register")
    public UserResponse register(@RequestBody RegisterRequest registerRequest) throws SQLException {
      return userServices.register(registerRequest);
    }

    @GetMapping(value = "/profile/{phoneID}")
    public UserResponse getProfilebyPhone(@PathVariable(name = "phoneID") String phoneID ){
        return userServices.showProfile(phoneID);
    }


}
