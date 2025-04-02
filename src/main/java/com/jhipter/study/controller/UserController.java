package com.jhipter.study.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhipter.study.domain.User;
import com.jhipter.study.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("users/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {

        this.userService.deleteUser(id);
    }

    @GetMapping("users")
    public List<User> ListUsers() {
        return this.userService.getListUser();
    }

}
