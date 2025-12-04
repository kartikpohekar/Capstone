package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Download {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long downloadId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Long appId;  // App comes from owner-ms

    private LocalDateTime downloadedAt = LocalDateTime.now();
}
