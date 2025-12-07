package com.example.controller;

import com.example.entity.Download;
import com.example.service.DownloadService;
import com.example.client.NotificationClient;
import com.example.dto.NotificationRequest;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/user/downloads")
public class DownloadController {

    @Autowired
    private DownloadService service;

    @Autowired
    private NotificationClient notifier;

    @PostMapping
    public Download download(@RequestBody Download d){
        Download saved = service.save(d);

        try {
            NotificationRequest n = new NotificationRequest(
                null,
                d.getAppId(),
                "DOWNLOAD",
                "User " + d.getUserId() + " downloaded your app"
            );

            notifier.send(n);
        } catch(Exception ignored){}

        return saved;
    }

    @GetMapping("/count/{appId}")
    public long count(@PathVariable Long appId){
        return service.count(appId);
    }
}
