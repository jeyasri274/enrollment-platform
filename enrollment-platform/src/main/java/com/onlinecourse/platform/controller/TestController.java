package com.onlinecourse.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @GetMapping("/test")
    public String test() {
        return "Application is running!";
    }
    
    @GetMapping("/test-db")
    public String testDatabase() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return "Database connected successfully!";
        } catch (Exception e) {
            return "Database connection failed: " + e.getMessage();
        }
    }
}