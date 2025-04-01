package com.jhipter.study.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhipter.study.domain.User;
import com.jhipter.study.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthenticationController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User registerNewUserAccount(User accountDto) {
        User user = new User();
        user.setUserName(accountDto.getUserName());
        user.setEmail(accountDto.getEmail());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        // user.setGender(accountDto.getGender());
        user.setEmail(accountDto.getEmail());
        userRepository.save(user);
        return user;
    }
}
