package com.example.controller;

import com.example.dto.AuthRequest;
import com.example.dto.AuthResponse;
import com.example.entity.User;
import com.example.repo.UserRepository;
import com.example.security.JwtUtil;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/auth/user")
public class AuthController {

    @Autowired private UserRepository repo;
    @Autowired private PasswordEncoder encoder;
    @Autowired private JwtUtil jwt;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody User u){

        if (repo.findByUsername(u.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        u.setPassword(encoder.encode(u.getPassword()));
        User saved = repo.save(u);

        return new AuthResponse("REGISTERED", saved.getUserId(), saved.getUsername());
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req){

        User u = repo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!encoder.matches(req.getPassword(), u.getPassword()))
            throw new RuntimeException("Invalid credentials");

        String token = jwt.generateToken(u.getUsername(), u.getUserId());

        return new AuthResponse(token, u.getUserId(), u.getUsername());
    }
}
