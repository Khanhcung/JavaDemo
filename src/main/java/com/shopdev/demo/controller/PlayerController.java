package com.shopdev.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Value("${player.username}")
    private String username;
    @Value("${player.age}")
    private int age;
    @Value("${player.address}")
    private String address;

    @GetMapping("/v1/api/player-info")
    public String getPlayerInfo() {
        return "Player Info: Username=" + username + ", Age=" + age + ", Address=" + address;

    }
}
