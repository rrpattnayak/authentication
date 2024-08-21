package com.example.BasicAuth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BasicAuth.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
