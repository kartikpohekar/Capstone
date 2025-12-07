package com.example.controller;

import com.example.client.ReviewClient;
import com.example.dto.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner/reviews")
public class ReviewController {

    @Autowired
    private ReviewClient reviewClient;

    @GetMapping("/app/{appId}")
    public List<ReviewResponse> getReviews(@PathVariable Long appId){
        return reviewClient.getReviews(appId);
    }
}
