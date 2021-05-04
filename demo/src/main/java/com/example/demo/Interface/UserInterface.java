package com.example.demo.Interface;

import com.example.demo.controller.requests.LoginRequest;

import java.sql.SQLException;

public interface UserInterface {
    String login (LoginRequest loginRequest) throws SQLException;

}
