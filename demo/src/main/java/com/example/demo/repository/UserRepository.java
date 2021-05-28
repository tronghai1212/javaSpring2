package com.example.demo.repository;

import com.example.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findAllByPhoneUser(String phoneUser);
    List<UserEntity> findAllByPhoneUserOrEmailUser(String phoneUser, String emailUser);


}
