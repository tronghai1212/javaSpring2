package com.example.demo.connection;

import com.mysql.cj.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class Connection_Bean {
//    private static final String LINK_DB = "jdbc:mysql://localhost:3306/mydb";
//    private static final String ID_DB = "root";
//    private static final String PASS_DB = "Haideptraiok";
//
//    @Bean
//    Connection getConnection(){
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            if (connection ==null){
//                connection = DriverManager.getConnection(LINK_DB, ID_DB, PASS_DB);
//            }
//            else return connection;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return connection;
//    }
}
