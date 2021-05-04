package com.example.demo.services;

import com.example.demo.Interface.UserInterface;
import com.example.demo.controller.requests.LoginRequest;
import com.example.demo.controller.requests.RegisterRequest;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class UserServices implements UserInterface {
    @Autowired
    Connection connection;

    @Override
    public String login(LoginRequest loginRequest) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM `mydb`.`user` WHERE sdt_user = " + loginRequest.getNumberPhone() + ";";
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            User user = new User(rs.getString("sdt_user"), rs.getString("pass_user"));
            if ((loginRequest.getNumberPhone().equals(user.getNumberPhone()) == true)) {
                if ((loginRequest.getPassWord().equals(user.getPassword()) == true)) {
                    return "login Successful";
                }
                return "Password sai";
            }
        }
        return "account is not exist";
    }

    @Override
    public String register(RegisterRequest registerRequest) throws SQLException {
        Statement statement = connection.createStatement();
        String count = "count";
        String sql = "SELECT COUNT(*) as "+count+" FROM `mydb`.`user` WHERE sdt_user = "+registerRequest.getNumberPhone()+";";
        ResultSet rs = statement.executeQuery(sql);
        User user= new User(registerRequest.getNumberPhone(), registerRequest.getEmail(), registerRequest.getPassWord());
            while (rs.next()){
                int a = rs.getInt("count");
                if (a == 0){
                    if (user.checkEmail(user.getEmail()) == false){
                        return "email invaid";
                    }

                    else if (user.checknumberPhone(user.getNumberPhone()) == false){
                        return "numberphone invaid";
                    }
                    else if (user.checkpassWord(user.getPassword()) == false){
                        return "password invaid";
                    }
                    else {
                        String sql1 = "INSERT INTO `mydb`.`user` (`sdt_user`, `email_user`, `pass_user`) " +
                                "VALUES ('"+user.getNumberPhone()
                                +"', '"+user.getEmail()
                                +"', '"+user.getPassword()+"');\n";
                        statement.executeUpdate(sql1);
                        return "register done";
                    }
                }
            }
        return count;
    }

}
