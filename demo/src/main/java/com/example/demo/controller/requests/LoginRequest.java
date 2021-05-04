package com.example.demo.controller.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String numberPhone;
    private String passWord;
}