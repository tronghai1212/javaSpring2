package com.example.demo.Interface;

import com.example.demo.controller.requests.LoginRequest;
import com.example.demo.controller.requests.RegisterRequest;

import java.sql.SQLException;

public interface UserInterface {
    String login (LoginRequest loginRequest) throws SQLException;
    String register (RegisterRequest registerRequest) throws SQLException;
}
