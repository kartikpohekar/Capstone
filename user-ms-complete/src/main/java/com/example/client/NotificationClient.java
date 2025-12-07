package com.example.client;

import com.example.dto.NotificationRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NotificationClient {

    private final RestTemplate rest = new RestTemplate();
    private final String NOTIFY_URL = "http://localhost:8082/owner/notify";

    public void send(NotificationRequest req) {
        try {
            rest.postForObject(NOTIFY_URL, req, Void.class);
        } catch (Exception e) {
            System.out.println("Failed to send notification: " + e.getMessage());
        }
    }
}
