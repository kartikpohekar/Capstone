package com.example.service;
import com.example.entity.User;
import com.example.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User save(User u){
        return repo.save(u);
    }

    public User findByUsername(String u){
        return repo.findByUsername(u).orElseThrow();
    }
}
