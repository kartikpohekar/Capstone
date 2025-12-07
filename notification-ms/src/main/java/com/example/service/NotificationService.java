package com.example.service;

import com.example.entity.Notification;
import com.example.repo.NotificationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repo;

    public NotificationService(NotificationRepository repo){
        this.repo = repo;
    }

    public Notification create(Notification n){
        return repo.save(n);
    }

    public List<Notification> getByOwner(Long ownerId){
        return repo.findByOwnerIdOrderByTimestampDesc(ownerId);
    }

    public Notification markRead(Long id){
        Notification n = repo.findById(id).orElseThrow();
        n.setReadStatus(true);
        return repo.save(n);
    }
}
