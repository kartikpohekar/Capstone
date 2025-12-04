package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String version;
    private String genre;

    private boolean visibility = true;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
