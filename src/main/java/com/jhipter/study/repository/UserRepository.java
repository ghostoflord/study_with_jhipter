package com.jhipter.study.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhipter.study.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByResetKey(String resetKey);

    Optional<User> findOneByEmailIgnoreCase(String email);
}
