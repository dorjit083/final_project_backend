package com.athang.javatraining.participant_engagement_system.controller;

import com.athang.javatraining.participant_engagement_system.model.Password;
import com.athang.javatraining.participant_engagement_system.service.PasswordServices;
import com.athang.javatraining.participant_engagement_system.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/password")
public class PasswordController {

    private final PasswordServices passwordServices;

    public PasswordController(PasswordServices passwordServices) {
        this.passwordServices = passwordServices;
    }

    @PostMapping("/addPassword")
    public ResponseEntity<?> addPassword(@RequestBody Password password) {
        // Check if username already exists in the database
        if (passwordServices.existsByUsername(password.getUsername())) {
            // Username already exists, return a conflict response
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }

        // Username doesn't exist, proceed with registration
        Password savedPassword = passwordServices.addPassword(password);
        return ResponseEntity.ok(savedPassword);
    }

    @DeleteMapping("/deletePassword/{id}")
    public String deletePassword(@PathVariable int id){
        return passwordServices.deletePassword(id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Password password) {
        boolean authenticated = passwordServices.authenticateUser(password.getUsername(), password.getPassword());
        if (authenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

}

