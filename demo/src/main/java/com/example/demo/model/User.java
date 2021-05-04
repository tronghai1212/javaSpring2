package com.example.demo.model;

import com.example.demo.Interface.CheckUserInterface;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Pattern;
@Getter
@Setter
public class User implements CheckUserInterface {
    private String numberPhone;
    private String email;
    private String password;

    public User(String numberPhone, String password) {
        this.numberPhone = numberPhone;
        this.password = password;
    }

    public User(String numberPhone, String email, String password) {
        this.numberPhone = numberPhone;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean checknumberPhone(String numberPhone) {
        String PHONE_PATTERN = "^[0-9]{10}";
        if (Pattern.matches(PHONE_PATTERN, numberPhone) == true){
            return true;
        }
        else return false;
    }

    @Override
    public boolean checkEmail(String email) {
        String EMAIL_PATTERN =   "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        if (Pattern.matches(EMAIL_PATTERN, email) == true){
            return true;
        }
        else return false;
    }

    @Override
    public boolean checkpassWord(String password) {
        if (password.length() <=8){
            return false;
        }
        else return true;
    }
}
