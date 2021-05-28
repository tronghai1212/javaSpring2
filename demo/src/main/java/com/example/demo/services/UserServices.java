package com.example.demo.services;

import com.example.demo.Interface.UserInterface;
import com.example.demo.controller.requests.LoginRequest;
import com.example.demo.controller.requests.RegisterRequest;
import com.example.demo.controller.response.UserResponse;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
public class UserServices implements UserInterface {
    //    @Autowired
//    Connection connection;
    @Autowired
    UserRepository userRepository;


    public UserResponse login(LoginRequest loginRequest) throws SQLException {
//        Statement statement = connection.createStatement();
//        String sql = "SELECT * FROM `mydb`.`user` WHERE sdt_user = " + loginRequest.getNumberPhone() + ";";
//        ResultSet rs = statement.executeQuery(sql);
//
//        while (rs.next()) {
//            User user = new User(rs.getString("sdt_user"), rs.getString("pass_user"));
//            if ((loginRequest.getNumberPhone().equals(user.getNumberPhone()) == true)) {
//                if ((loginRequest.getPassWord().equals(user.getPassword()) == true)) {
//                    return "login Successful";
//                }
//                return "Password sai";
//            }
//        }
        UserResponse response = new UserResponse();
        UserEntity entity = userRepository.findAllByPhoneUser(loginRequest.getNumberPhone());
        if (entity.getPhoneUser().equals(loginRequest.getNumberPhone()) == true) {
            if (entity.getPassUser().equals(loginRequest.getPassWord()) == true) {
                response.setCode(200);
                response.setMessage("Login oke");
                return response;
            } else {
                response.setCode(404);
                response.setMessage("Login Failed");
                return response;
            }
        } else {
            response.setCode(500);
            response.setMessage("Account is not existed");
            return response;
        }

    }


    public UserResponse register(RegisterRequest registerRequest) throws SQLException {
//        Statement statement = connection.createStatement();
//        String count = "count";
//        String sql = "SELECT COUNT(*) as "+count+" FROM `mydb`.`user` WHERE sdt_user = "+registerRequest.getNumberPhone()+";";
//        ResultSet rs = statement.executeQuery(sql);
//        User user= new User(registerRequest.getNumberPhone(), registerRequest.getEmail(), registerRequest.getPassWord());
//            while (rs.next()){
//                int a = rs.getInt("count");
//                if (a == 0){
//                    if (user.checkEmail(user.getEmail()) == false){
//                        return "email invaid";
//                    }
//
//                    else if (user.checknumberPhone(user.getNumberPhone()) == false){
//                        return "numberphone invaid";
//                    }
//                    else if (user.checkpassWord(user.getPassword()) == false){
//                        return "password invaid";
//                    }
//                    else {
//                        String sql1 = "INSERT INTO `mydb`.`user` (`sdt_user`, `email_user`, `pass_user`) " +
//                                "VALUES ('"+user.getNumberPhone()
//                                +"', '"+user.getEmail()
//                                +"', '"+user.getPassword()+"');\n";
//                        statement.executeUpdate(sql1);
//                        return "register done";
//                    }
//                }
//            }
        UserResponse response = new UserResponse();
        List<UserEntity> userEntity = userRepository.findAllByPhoneUserOrEmailUser(registerRequest.getNumberPhone(), registerRequest.getEmail());
        UserEntity userEntity1 = new UserEntity(registerRequest.getNumberPhone(), registerRequest.getEmail(), registerRequest.getPassWord());
        if (userEntity.size() != 0) {
            response.setCode(100);
          //  response.setData(userEntity);
            response.setMessage("Account is existed");
            return response;
        } else {
            if (userEntity1.checkEmail(userEntity1.getEmailUser()) == false) {
                return null;
            } else if (userEntity1.checknumberPhone(userEntity1.getPhoneUser()) == false) {
                return null;
            } else if (userEntity1.checkpassWord(userEntity1.getPassUser()) == false) {
                return null;
            } else {
                UserEntity addUser = new UserEntity();
                addUser.setPhoneUser(registerRequest.getNumberPhone());
                addUser.setEmailUser(registerRequest.getEmail());
                addUser.setPassUser(registerRequest.getPassWord());
                userRepository.save(addUser);
                response.setCode(200);
                response.setData(addUser);
                response.setMessage("Success");
                return response;


            }
        }
    }


    public UserResponse showProfile(String phoneNumber){
        UserEntity userEntity = userRepository.findAllByPhoneUser(phoneNumber);
        UserResponse response = new UserResponse();
        response.setCode(200);
        response.setData(userEntity);
        response.setMessage("Success");
        return response;
    }
}

