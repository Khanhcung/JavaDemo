package com.shopdev.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.shopdev.demo.util.EmailSendUtil;



@SpringBootTest
public class SendEmailTest {
    

    @Autowired

    private EmailSendUtil emailSendUtil;

    @Test

    void sendEmailTest() {
        String to = "cungkhanh0511@hotmail.com";  
        String subject = "test email";   
        String body = "This is a test email sent from Spring Boot application.";

        emailSendUtil.sendEmail(to, subject, body);
          // Implement test logic for sending email
        // Example:
        // emailSendUtil.sendEmail("
    }


     @Test

    void sendHtmlEmailTest() {
        String to = "cungkhanh0511@hotmail.com";  
        String subject = "test email";   
        String body = "This is a test email sent from Spring Boot application.";

        Resource  resource = new ClassPathResource("templates/email/otpauth.html");

        try {

            String htmlContent =  new String(resource.getInputStream().readAllBytes());

            emailSendUtil.sendHtmlEmail(to, subject, htmlContent);


        } catch (Exception e) {
            System.err.println("Failed to read HTML template: " + e.getMessage());
            
        }



          // Implement test logic for sending email
        // Example:
        // emailSendUtil.sendEmail("
    }
}
