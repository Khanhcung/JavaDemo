package com.shopdev.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopdev.demo.entity.EmailEntity;
import com.shopdev.demo.services.EmailService;

@RestController
@RequestMapping("/v1/api/email")
public class EmailController {
    
    @Autowired

    private EmailService emailService;

    @PostMapping("/send-text")
    public String sendTextEmail(@RequestBody EmailEntity emailEntity) {
        return emailService.sendEmail(emailEntity);
    }


     @PostMapping("/send-html")
    public String sendHtmlEmail(@RequestBody EmailEntity emailEntity) {
        return emailService.sendHtmlEmail(emailEntity);
    }
}
