package com.example.client;

import com.example.dto.ReviewResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "USER-MS")
public interface ReviewClient {

    @GetMapping("/user/reviews/{appId}")
    List<ReviewResponse> getReviews(@PathVariable Long appId);
}
