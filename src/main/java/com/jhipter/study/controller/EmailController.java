package com.jhipter.study.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import com.jhipter.study.domain.EmailRequest;
import com.jhipter.study.service.EmailService;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        Context context = new Context();
        // Set variables for the template from the POST request data
        context.setVariable("name", emailRequest.getName());
        context.setVariable("message", emailRequest.getMessage());
        context.setVariable("subject", emailRequest.getSubject());
        try {
            emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), "emailTemplate", context);
            return "Email sent successfully!";
        } catch (Exception e) {
            return "Error sending email: " + e.getMessage();
        }
    }


    
}
