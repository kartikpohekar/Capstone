package com.example.controller;

import com.example.entity.Owner;
import com.example.repo.OwnerRepository;
import com.example.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner/auth")
public class OwnerAuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private OwnerRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Owner req) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
        );

        String token = jwtUtil.generateToken(req.getUsername());

        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Owner req) {

        // store password directly (same as USER-MS)
        repo.save(req);

        return ResponseEntity.ok(jwtUtil.generateToken(req.getUsername()));
    }
}
