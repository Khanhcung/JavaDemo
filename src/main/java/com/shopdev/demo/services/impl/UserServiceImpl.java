package com.shopdev.demo.services.impl;

import com.shopdev.demo.entity.user.UserEntity;
import com.shopdev.demo.repository.UserRepo;
import com.shopdev.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserEntity create(UserEntity entity) {
        return userRepo.save(entity);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepo.findAll() ;
    }

    @Override
    public UserEntity findByUsernameAndEmail(String userName, String email) {


        return userRepo.findByUsernameAndEmail(userName, email);
    }

    @Override
    public Page<UserEntity> findAllUsers(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    public Page<UserEntity> findByUsername(String username, Pageable pageable) {
        return userRepo.findByUsername(username,pageable);

    }

    @Override
    public Long getTotal() {
        return userRepo.getTotalUser();
    }
}
