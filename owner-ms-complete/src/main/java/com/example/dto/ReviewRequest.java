package com.example.dto;
public class ReviewRequest {
    private Long appId;
    private Long userId;
    private String comment;
    private int rating;

    public Long getAppId(){return appId;}
    public void setAppId(Long id){this.appId=id;}

    public Long getUserId(){return userId;}
    public void setUserId(Long id){this.userId=id;}

    public String getComment(){return comment;}
    public void setComment(String c){this.comment=c;}

    public int getRating(){return rating;}
    public void setRating(int r){this.rating=r;}
}
