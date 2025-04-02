package com.jhipter.study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhipter.study.domain.User;
import com.jhipter.study.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    public List<User> getListUser() {
        return this.userRepository.findAll();
    }

}
