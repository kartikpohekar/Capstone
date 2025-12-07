package com.example.client;

import com.example.entity.App;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "owner-ms", url = "${owner.ms.url}", contextId = "appClient")
public interface AppClient {

    @GetMapping("/apps/{id}")
    App getApp(@PathVariable Long id);
}
