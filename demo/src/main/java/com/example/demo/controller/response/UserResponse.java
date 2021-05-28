package com.example.demo.controller.response;

import com.example.demo.model.BookEntity;
import com.example.demo.model.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class UserResponse {
    private Integer code;
    private String message;
    private UserEntity data;
}
