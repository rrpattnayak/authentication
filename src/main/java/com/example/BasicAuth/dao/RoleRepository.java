package com.example.BasicAuth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BasicAuth.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

