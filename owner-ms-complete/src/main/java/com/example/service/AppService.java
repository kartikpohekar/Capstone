package com.example.service;

import com.example.entity.App;
import com.example.repo.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppService {

    @Autowired
    private AppRepository repo;

    public App save(App a) {
        return repo.save(a);
    }

    public App find(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);   // ⭐ Fix added
    }

    public List<App> findByOwnerId(Long ownerId) {
        return repo.findByOwnerId(ownerId);
    }

    public List<App> findVisibleApps() {
        return repo.findByVisibleTrue();
    }

    public List<App> searchVisibleApps(String query) {
        return repo.findByNameContainingIgnoreCaseAndVisibleTrue(query);
    }
}
