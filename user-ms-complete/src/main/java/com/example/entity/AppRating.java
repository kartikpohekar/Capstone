package com.example.entity;
import jakarta.persistence.*;

@Entity
@Table(name="app_rating")
public class AppRating {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long appId;
    private Long userId;
    private int rating;

    @Column(length = 2000)
    private String comment;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public Long getAppId(){return appId;}
    public void setAppId(Long id){this.appId=id;}

    public Long getUserId(){return userId;}
    public void setUserId(Long id){this.userId=id;}

    public int getRating(){return rating;}
    public void setRating(int r){this.rating=r;}

    public String getComment(){return comment;}
    public void setComment(String c){this.comment=c;}
}
