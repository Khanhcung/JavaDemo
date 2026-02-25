package com.shopdev.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @Autowired
    JdbcTemplate jdbcTemplate;


    @GetMapping("/v1/api/hello")
    public String Hello() {
        Integer one = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        return "hello" + "DB OK, result = " + one;
    }

    @GetMapping("/v1/api/hello_new")
    public String HelloNew() {
        return "hello 2";
    }
}
