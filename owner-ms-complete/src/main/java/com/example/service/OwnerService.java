package com.example.service;
import com.example.entity.Owner;
import com.example.repo.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository repo;

    public Owner save(Owner o){
        return repo.save(o);
    }

    public Owner findByUsername(String username){
        return repo.findByUsername(username).orElseThrow();
    }
}
