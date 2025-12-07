package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "app")
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appId;

    private String name;
    private String description;
    private String version;
    private String genre;

    private Boolean visible = true;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "icon_url")
    private String iconUrl;  // ⭐ NEW FIELD

    public Long getAppId() { return appId; }
    public void setAppId(Long appId) { this.appId = appId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public Boolean getVisible() { return visible; }
    public void setVisible(Boolean visible) { this.visible = visible; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public String getIconUrl() { return iconUrl; }     // ⭐ NEW
    public void setIconUrl(String iconUrl) { this.iconUrl = iconUrl; } // ⭐ NEW
}
