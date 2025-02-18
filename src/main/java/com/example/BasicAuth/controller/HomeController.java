package com.example.BasicAuth.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String home(Model model) {
        // Check if the user is an admin to show the interest button
        boolean isAdmin = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().contains("ROLE_ADMIN");
        model.addAttribute("isAdmin", isAdmin);
        return "index";
    }

    @GetMapping("/balance")
    public String getBalance() {
        // Logic for showing account balance
        return "balance";
    }

    @GetMapping("/interest")
    public String getInterestRate() {
        // Logic for showing interest rate (restricted to admin)
        return "interestRate";
    }
}














/*
 * @Controller public class HomeController {
 * 
 * @Autowired private AccountService accountService;
 * 
 * @Autowired private InterestRateService interestRateService;
 * 
 * @GetMapping("/") public String home(Model model, @AuthenticationPrincipal
 * User user) { model.addAttribute("username", user.getUsername()); return
 * "home"; }
 * 
 * @GetMapping("/account-balance") public String showAccountBalance(Model
 * model, @AuthenticationPrincipal User user) { // Call the AccountService to
 * get the balance String balance =
 * accountService.getAccountBalance(user.getUsername());
 * 
 * // Add the account balance to the model to display it in the view
 * model.addAttribute("balance", balance); return "account-balance"; }
 * 
 * @GetMapping("/interest-rate") public String showInterestRate(Model model) {
 * // Call the InterestRateService to get the current interest rate String
 * interestRate = interestRateService.getInterestRate();
 * 
 * // Add the interest rate to the model to display it in the view
 * model.addAttribute("interestRate", interestRate); return "interest-rate"; } }
 */