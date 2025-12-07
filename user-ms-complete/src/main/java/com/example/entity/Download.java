package com.example.entity;
import jakarta.persistence.*;

@Entity
@Table(name="download")
public class Download {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long downloadId;

    private Long appId;
    private Long userId;

    public Long getDownloadId(){return downloadId;}
    public void setDownloadId(Long id){this.downloadId=id;}

    public Long getAppId(){return appId;}
    public void setAppId(Long id){this.appId=id;}

    public Long getUserId(){return userId;}
    public void setUserId(Long id){this.userId=id;}
}
