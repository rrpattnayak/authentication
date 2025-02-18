package com.example.BasicAuth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BasicAuth.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // You can add custom queries here if needed
}
