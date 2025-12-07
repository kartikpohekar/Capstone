package com.example.controller;

import com.example.client.OwnerAppClient;
import com.example.entity.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/apps")
public class AppClientController {

    @Autowired
    private OwnerAppClient client;

    @GetMapping("/visible")
    public List<App> visible() {
        return client.getVisibleApps();
    }
}
