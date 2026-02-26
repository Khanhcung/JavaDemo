package com.shopdev.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSendUtil {

    private static final String EMAIL_HOST = "cungkhanh05111994@gmail.com";

    @Autowired

    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        // Implement email sending logic using JavaMailSender
        // Example:
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(EMAIL_HOST);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
        try {
            // Send email logic here
            mailSender.send(message);
            System.out.println("Email sent successfully to " + to);
        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
}
