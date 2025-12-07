package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.entity.App;
import java.util.List;

@FeignClient(name = "owner-ms")
public interface OwnerAppClient {

    @GetMapping("/apps/visible")
    List<App> getVisibleApps();
}
