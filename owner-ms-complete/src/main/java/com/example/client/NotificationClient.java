package com.example.client;

import com.example.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-ms", url = "${notification.ms.url}")
public interface NotificationClient {
    @PostMapping("/notifications")
    Object notify(@RequestBody NotificationRequest req);
}
