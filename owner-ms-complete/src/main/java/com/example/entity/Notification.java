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
    private String message;
    private String type;
    private LocalDateTime timestamp;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public Long getOwnerId(){ return ownerId; }
    public void setOwnerId(Long ownerId){ this.ownerId = ownerId; }

    public Long getAppId(){ return appId; }
    public void setAppId(Long appId){ this.appId = appId; }

    public String getMessage(){ return message; }
    public void setMessage(String message){ this.message = message; }

    public String getType(){ return type; }
    public void setType(String type){ this.type = type; }

    public LocalDateTime getTimestamp(){ return timestamp; }
    public void setTimestamp(LocalDateTime timestamp){ this.timestamp = timestamp; }
}
