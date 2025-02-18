package com.example.BasicAuth.service;

import org.springframework.stereotype.Service;

@Service
public class InterestRateService {

    // Mocking an interest rate retrieval, in a real-world scenario, this could be from a database
    public String getInterestRate() {
        // Example logic to simulate fetching the interest rate
        return "5.5%";
    }
}

