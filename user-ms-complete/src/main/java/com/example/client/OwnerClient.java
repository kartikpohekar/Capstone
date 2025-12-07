package com.example.client;

import com.example.dto.ReviewRequest;
import com.example.entity.App;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "owner-ms", contextId = "ownerClient", url="${owner.ms.url}")
public interface OwnerClient {

    @GetMapping("/apps/{id}")
    App getApp(@PathVariable Long id);

    @PostMapping("/owner/reviews")
    Object sendReview(@RequestBody ReviewRequest req);

    @PostMapping("/owner/download-notify")
    Object notifyDownload(@RequestBody Object payload);
}
