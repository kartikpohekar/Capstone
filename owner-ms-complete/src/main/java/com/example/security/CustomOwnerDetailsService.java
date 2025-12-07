package com.example.security;
import com.example.entity.Owner;
import com.example.repo.OwnerRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collections;

@Service
public class CustomOwnerDetailsService implements UserDetailsService {

    @Autowired
    private OwnerRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Owner o = repo.findByUsername(username).orElseThrow();
        return new org.springframework.security.core.userdetails.User(o.getUsername(), o.getPassword(), Collections.emptyList());
    }
}
