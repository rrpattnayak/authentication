package com.example.BasicAuth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.BasicAuth.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll() // Allow registration and login without authentication
                //.antMatchers("/home").permitAll()
                .antMatchers("/getMessage").hasRole("USER") // Require USER role for /getMessage
                .antMatchers("/admin/**").hasRole("ADMIN") // Require ADMIN role for /admin/**
                .antMatchers("/balance").permitAll()
                .antMatchers("/interest").hasRole("ADMIN")
                .antMatchers("/index/**").permitAll()
                .anyRequest().authenticated() // All other requests require authentication
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
            .httpBasic(); // Use HTTP Basic Authentication
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
