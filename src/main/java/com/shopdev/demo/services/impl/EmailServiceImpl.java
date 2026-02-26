package com.shopdev.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.shopdev.demo.entity.EmailEntity;
import com.shopdev.demo.services.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;



@Service
public  class EmailServiceImpl implements EmailService {


    @Value("${email.username}")
    private static  String EMAIL_HOST;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String sendEmail(EmailEntity emailEntity) {
        // Implement logic to send plain text email

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(EMAIL_HOST);
        message.setTo(emailEntity.getTo());
        message.setSubject(emailEntity.getSubject());
        message.setText(emailEntity.getBody());
        mailSender.send(message);
        try {
            // Send email logic here
            mailSender.send(message);
            //System.out.println("Email sent successfully to " + to);

        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
        return "Plain text email sent successfully  ";

    }

    @Override
    public String sendHtmlEmail(EmailEntity emailEntity) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setFrom(EMAIL_HOST);
            helper.setTo(emailEntity.getTo());
            helper.setSubject(emailEntity.getSubject());
            helper.setText(emailEntity.getBody(), true); // true = isHtml

            mailSender.send(mimeMessage);
            System.out.println("Email sent successfully to " + emailEntity.getTo());
        } catch (MessagingException e) {
            System.err.println("Failed to create/send HTML email: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error sending HTML email: " + e.getMessage());
        }

        // Implement logic to send HTML email
        return "HTML email sent successfully to " + emailEntity.getTo();
    }

    @Override
    public String sendAttachmentEmail(EmailEntity emailEntity) {
        // Implement logic to send email with attachment
        return "Email with attachment sent successfully to " + emailEntity.getTo();
    }
}
