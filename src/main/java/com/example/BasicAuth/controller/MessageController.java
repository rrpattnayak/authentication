package com.example.BasicAuth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GetMapping("/getMessage")
    @PreAuthorize("hasRole('USER')") // Require USER role
    public String getMessage() {
        return "Hello, this is a secured message for USER!";
    }

    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('ADMIN')") // Require ADMIN role
    public String getAdminDashboard() {
        return "Welcome to the Admin Dashboard!";
    }
}

