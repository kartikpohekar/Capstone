package com.example.dto;

public class NotificationRequest {
    private Long ownerId;
    private Long appId;
    private String type;
    private String message;

    public NotificationRequest() {}

    public NotificationRequest(Long ownerId, Long appId, String type, String message) {
        this.ownerId = ownerId;
        this.appId = appId;
        this.type = type;
        this.message = message;
    }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public Long getAppId() { return appId; }
    public void setAppId(Long appId) { this.appId = appId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
