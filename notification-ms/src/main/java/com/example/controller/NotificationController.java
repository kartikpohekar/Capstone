package com.example.controller;

import com.example.dto.NotificationRequest;
import com.example.entity.Notification;
import com.example.service.NotificationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service){
        this.service = service;
    }

    @PostMapping
    public Notification create(@RequestBody NotificationRequest req){
        Notification n = new Notification(req.getOwnerId(), req.getAppId(), req.getType(), req.getMessage());
        return service.create(n);
    }

    @GetMapping("/{ownerId}")
    public List<Notification> getByOwner(@PathVariable Long ownerId){
        return service.getByOwner(ownerId);
    }

    @PutMapping("/mark-read/{id}")
    public Notification markRead(@PathVariable Long id){
        return service.markRead(id);
    }
}
