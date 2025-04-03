package com.jhipter.study.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhipter.study.domain.User;
import com.jhipter.study.service.EmailService;
import com.jhipter.study.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;
    private final EmailService emailService;

    public UserController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @DeleteMapping("users/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {

        this.userService.deleteUser(id);
    }

    @GetMapping("users")
    public List<User> ListUsers() {
        return this.userService.getListUser();
    }

    @PostMapping(path = "users/account/reset-password/init")
    public void requestPasswordReset(@RequestBody String mail) {
        Optional<User> user = userService.requestPasswordReset(mail);
        if (user.isPresent()) {
            emailService.sendPasswordResetMail(user.orElseThrow());
        } else {
        }
    }

}
