package com.example.demo.Interface;

import com.example.demo.controller.requests.LoginRequest;
import com.example.demo.controller.requests.RegisterRequest;
import com.example.demo.controller.response.UserResponse;
import com.example.demo.model.UserEntity;

import java.sql.SQLException;

public interface UserInterface {
    UserResponse login (LoginRequest loginRequest) throws SQLException;
    UserResponse register (RegisterRequest registerRequest) throws SQLException;
}
