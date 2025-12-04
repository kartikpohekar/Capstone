package com.example.service;

import com.example.entity.Owner;
import com.example.repo.OwnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class OwnerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private OwnerRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Owner owner = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Owner not found"));

        return User.withUsername(owner.getUsername())
                .password(owner.getPassword())  // plain text
                .roles("OWNER")
                .build();
    }
}
