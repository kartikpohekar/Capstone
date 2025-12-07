package com.example.controller;

import com.example.entity.Owner;
import com.example.repo.OwnerRepository;
import com.example.security.JwtUtil;
import com.example.dto.AuthRequest;
import com.example.dto.AuthResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/owner")
public class OwnerAuthController {

    @Autowired private OwnerRepository repo;
    @Autowired private PasswordEncoder encoder;
    @Autowired private JwtUtil jwt;

    @PostMapping("/register")
    public String register(@RequestBody Owner o) {
        o.setPassword(encoder.encode(o.getPassword()));
        repo.save(o);
        return "SUCCESS";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        Owner o = repo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        if (!encoder.matches(req.getPassword(), o.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwt.generateToken(o.getUsername(), o.getOwnerId());
        return new AuthResponse(token, o.getOwnerId(), o.getUsername());
    }
}
