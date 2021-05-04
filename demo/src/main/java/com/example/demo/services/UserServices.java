package com.example.demo.services;

import com.example.demo.Interface.UserInterface;
import com.example.demo.controller.requests.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class UserServices implements UserInterface {
    @Autowired
    Connection connection;

    @Override
    public String login(LoginRequest loginRequest) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM `mydb`.`user` WHERE sdt_user = "+ loginRequest.getNumberPhone()+";";
        ResultSet rs =statement.executeQuery(sql);
        if (loginRequest.getNumberPhone().equals(rs.getString("sdt_user")) == true){
            if (loginRequest.getPassWord().equals(rs.getString("pass_user")) == true) {
                return "login Successful";
            }
            else return "Password sai";
        }
        else return "account is not exist";
    }
}
