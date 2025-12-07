package com.example.dto;

public class NotificationRequest {
    private Long ownerId;
    private Long appId;
    private String type;
    private String message;

    public NotificationRequest() {}

    public NotificationRequest(Long ownerId, Long appId, String type, String message){
        this.ownerId = ownerId;
        this.appId = appId;
        this.type = type;
        this.message = message;
    }

    public Long getOwnerId(){ return ownerId; }
    public void setOwnerId(Long id){ this.ownerId = id; }

    public Long getAppId(){ return appId; }
    public void setAppId(Long id){ this.appId = id; }

    public String getType(){ return type; }
    public void setType(String t){ this.type = t; }

    public String getMessage(){ return message; }
    public void setMessage(String m){ this.message = m; }
}
