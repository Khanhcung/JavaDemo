package com.shopdev.demo.services;

import org.springframework.stereotype.Service;

import com.shopdev.demo.entity.EmailEntity;


@Service
public interface EmailService {
    String sendEmail(EmailEntity emailEntity);
    String sendHtmlEmail(EmailEntity emailEntity);
    String sendAttachmentEmail(EmailEntity emailEntity);
}
