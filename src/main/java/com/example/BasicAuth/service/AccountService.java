package com.example.BasicAuth.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    // Mocking an account balance retrieval, in a real-world scenario, you could fetch this from a database
    public String getAccountBalance(String username) {
        // Example logic to simulate account balance fetching based on username
        if ("user".equals(username)) {
            return "$1,250.00";
        } else {
            return "$0.00";
        }
    }
}


