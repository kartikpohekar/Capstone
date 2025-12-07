package com.example.controller;

import com.example.entity.Notification;
import com.example.repo.NotificationRepository;
import com.example.repo.AppRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/owner")
public class NotificationController {

    @Autowired
    private NotificationRepository repo;

    @Autowired
    private AppRepository appRepo;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/notify")
    public void notifyOwner(@RequestBody Notification incoming) {

        Long ownerId = incoming.getOwnerId();

        if (ownerId == null && incoming.getAppId() != null) {
            ownerId = appRepo.findOwnerIdByAppId(incoming.getAppId());
            incoming.setOwnerId(ownerId);
        }

        incoming.setTimestamp(LocalDateTime.now());
        repo.save(incoming);

        if (ownerId != null) {
            messagingTemplate.convertAndSend("/topic/owner/" + ownerId, incoming);
        }
    }

    @GetMapping("/notifications/{ownerId}")
    public List<Notification> getNotifications(@PathVariable Long ownerId) {
        return repo.findByOwnerIdOrderByTimestampDesc(ownerId);
    }
}
