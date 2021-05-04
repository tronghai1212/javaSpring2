package com.example.demo.controller;

import com.example.demo.Interface.UserInterface;
import com.example.demo.connection.Connection_Bean;
import com.example.demo.controller.requests.LoginRequest;
import com.example.demo.controller.requests.RegisterRequest;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    UserServices userServices;

    @GetMapping(value = "/check")
    public String Get(){
        return "OKEEEEE";
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody LoginRequest loginRequest) throws SQLException {
        String result  = userServices.login(loginRequest);
        return result;
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody RegisterRequest registerRequest) throws SQLException {
        String result = userServices.register(registerRequest);
        return result;
    }


}
