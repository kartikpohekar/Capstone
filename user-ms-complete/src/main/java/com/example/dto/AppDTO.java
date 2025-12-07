package com.example.dto;

public class AppDTO {

    private Long appId;
    private Long ownerId;
    private String name;

    public Long getAppId(){ return appId; }
    public void setAppId(Long id){ this.appId = id; }

    public Long getOwnerId(){ return ownerId; }
    public void setOwnerId(Long id){ this.ownerId = id; }

    public String getName(){ return name; }
    public void setName(String n){ this.name = n; }
}
