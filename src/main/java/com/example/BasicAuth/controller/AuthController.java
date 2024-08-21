package com.example.BasicAuth.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BasicAuth.Entity.Role;
import com.example.BasicAuth.Entity.User;
import com.example.BasicAuth.dao.RoleRepository;
import com.example.BasicAuth.dao.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Check if user already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken!");
        }
        
        // Encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Assign the default role (USER) to the new user
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Collections.singletonList(userRole));
        
        // Save the user
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }
    
    @PostMapping("/registerAdmin")
    public ResponseEntity<?> registerAdmin(@RequestBody User user) {
        // Check if user already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken!");
        }
        
        // Encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Assign the admin role
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        user.setRoles(Collections.singletonList(adminRole));
        
        // Save the user
        userRepository.save(user);
        return ResponseEntity.ok("Admin registered successfully!");
    }

}
