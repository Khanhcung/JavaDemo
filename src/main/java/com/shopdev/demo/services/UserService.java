package com.shopdev.demo.services;

import com.shopdev.demo.entity.user.UserEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService  {

    UserEntity create(UserEntity entity);

    List<UserEntity> getAll();

    UserEntity findByUsernameAndEmail(String userName,String email);


    Page<UserEntity> findAllUsers( Pageable pageable);


    Page<UserEntity> findByUsername(String username, Pageable pageable);

    Long getTotal();
}
