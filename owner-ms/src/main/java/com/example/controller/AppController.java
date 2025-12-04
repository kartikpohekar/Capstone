package com.example.controller;

import com.example.entity.App;
import com.example.entity.Owner;
import com.example.repo.AppRepository;
import com.example.repo.OwnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner/apps")
public class AppController {

    @Autowired
    private AppRepository appRepo;

    @Autowired
    private OwnerRepository ownerRepo;

    // ------------------------------
    // CREATE APP
    // ------------------------------
    @PostMapping("/{ownerId}")
    public ResponseEntity<?> addApp(@PathVariable Long ownerId, @RequestBody App app) {

        Owner owner = ownerRepo.findById(ownerId).orElse(null);

        if (owner == null) {
            return ResponseEntity.badRequest().body("Owner not found");
        }

        app.setOwner(owner);
        App saved = appRepo.save(app);

        return ResponseEntity.ok(saved);
    }

    // ------------------------------
    // GET ALL APPS
    // ------------------------------
    @GetMapping
    public List<App> getAllApps() {
        return appRepo.findAll();
    }

    // ------------------------------
    // GET APP BY ID
    // ------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<?> getAppById(@PathVariable Long id) {

        App app = appRepo.findById(id).orElse(null);

        if (app == null) {
            return ResponseEntity.badRequest().body("App not found");
        }

        return ResponseEntity.ok(app);
    }

    // ------------------------------
    // SEARCH BY NAME
    // ------------------------------
    @GetMapping("/search/{name}")
    public List<App> searchByName(@PathVariable String name) {
        return appRepo.findByNameContainingIgnoreCase(name);
    }

    // ------------------------------
    // SEARCH BY GENRE
    // ------------------------------
    @GetMapping("/genre/{genre}")
    public List<App> searchByGenre(@PathVariable String genre) {
        return appRepo.findByGenre(genre);
    }
}
