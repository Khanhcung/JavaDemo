package com.shopdev.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.shopdev.demo.entity.feed.FeedEntity;
import com.shopdev.demo.entity.user.UserEntity;
import com.shopdev.demo.repository.FeedRepo;
import com.shopdev.demo.repository.UserRepo;

import jakarta.transaction.Transactional;

@SpringBootTest
public class UserTest {
    
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FeedRepo feedRepo;

    @Test
    @Transactional
    @Rollback(false)

    void oneToManyTest() {
        UserEntity user = new UserEntity();
        FeedEntity feed1 = new FeedEntity();
        user.setUsername("Test User");
        user.setEmail("test@example.com   ");

        feed1.setTitle("title 1");
    
        user.setFeeds( new ArrayList<>(List.of(feed1)) );
        feed1.setUser(user);
        userRepo.save(user);
        feedRepo.save(feed1);
    }

}
