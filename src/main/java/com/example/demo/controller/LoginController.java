package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.service.LoginService;
import com.example.demo.tables.Login;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Login login) {
        // Plain text password for simplicity without JWT/Security
        login.setConfirmpassword(login.getPassword());
        Login savedUser = service.register(login);
        
        // Dummy token
        String dummyToken = "dummy-token-for-" + savedUser.getId();
        return ResponseEntity.ok(new AuthResponse(dummyToken, savedUser.getId(), savedUser.getUsername(), savedUser.getEmail()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        Login user = service.getUserByEmail(request.getEmail());
        
        if (user != null && user.getPassword().equals(request.getPassword())) {
            // Dummy token
            String dummyToken = "dummy-token-for-" + user.getId();
            return ResponseEntity.ok(new AuthResponse(dummyToken, user.getId(), user.getUsername(), user.getEmail()));
        }
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Login> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Login> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.getUserByEmail(email));
    }
}