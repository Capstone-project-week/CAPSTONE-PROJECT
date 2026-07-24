package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.service.LoginService;
import com.example.demo.tables.Login;
import com.example.demo.util.JwtUtil;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private LoginService service;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Login login) {
        
        login.setConfirmpassword(login.getPassword());
        Login savedUser = service.register(login);
        
        String jwtToken = jwtUtil.generateToken(savedUser.getId());
        return ResponseEntity.ok(new AuthResponse(jwtToken, savedUser.getId(), savedUser.getUsername(), savedUser.getEmail()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        Login user = service.getUserByEmail(request.getEmail());
        
        if (user != null && user.getPassword().equals(request.getPassword())) {
           
            String jwtToken = jwtUtil.generateToken(user.getId());
            return ResponseEntity.ok(new AuthResponse(jwtToken, user.getId(), user.getUsername(), user.getEmail()));
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