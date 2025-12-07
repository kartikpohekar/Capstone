package com.example.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ownerId;
    private Long appId;
    private String type;

    @Column(length = 2000)
    private String message;

    private boolean readStatus;
    private LocalDateTime timestamp;

    public Notification() {}

    public Notification(Long ownerId, Long appId, String type, String message) {
        this.ownerId = ownerId;
        this.appId = appId;
        this.type = type;
        this.message = message;
        this.readStatus = false;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId(){ return id; }
    public Long getOwnerId(){ return ownerId; }
    public Long getAppId(){ return appId; }
    public String getType(){ return type; }
    public String getMessage(){ return message; }
    public boolean isReadStatus(){ return readStatus; }
    public LocalDateTime getTimestamp(){ return timestamp; }

    public void setReadStatus(boolean s){ this.readStatus = s; }
}
