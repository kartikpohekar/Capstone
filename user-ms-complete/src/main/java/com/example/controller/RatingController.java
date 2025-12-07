package com.example.controller;

import com.example.dto.ReviewRequest;
import com.example.dto.RatingSummary;
import com.example.entity.AppRating;
import com.example.service.RatingService;
import com.example.client.NotificationClient;
import com.example.client.AppClient;
import com.example.dto.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/reviews")
public class RatingController {

    @Autowired
    private RatingService service;

    @Autowired
    private NotificationClient notifier;

    @Autowired
    private AppClient appClient;

    @PostMapping
    public AppRating add(@RequestBody ReviewRequest req) {

        AppRating r = new AppRating();
        r.setAppId(req.getAppId());
        r.setUserId(req.getUserId());
        r.setComment(req.getComment());
        r.setRating(req.getRating());

        AppRating saved = service.save(r);

        try {
            com.example.entity.App app = appClient.getApp(req.getAppId());

            NotificationRequest n = new NotificationRequest(
                    app.getOwnerId(),
                    req.getAppId(),
                    "REVIEW",
                    "New review posted for your app '" + app.getName() + "'"
            );

            notifier.send(n);
        } catch (Exception e) {}

        return saved;
    }

    @GetMapping("/{appId}")
    public List<AppRating> list(@PathVariable Long appId){
        return service.findByAppId(appId);
    }

    @GetMapping("/summary/{appId}")
    public RatingSummary getSummary(@PathVariable Long appId){
        double avg = service.getAverageRating(appId);
        long count = service.getReviewCount(appId);
        return new RatingSummary(avg, count);
    }
}
