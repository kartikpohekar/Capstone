package com.example.controller;

import com.example.entity.App;
import com.example.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {

    @Autowired
    private AppService service;

    @PostMapping("/owner/apps/upload-icon")
    public Map<String, String> uploadIcon(@RequestParam("file") MultipartFile file) throws Exception {
        String folder = "src/main/resources/static/icons/";
        File dir = new File(folder);
        if (!dir.exists()) dir.mkdirs();

        String original = file.getOriginalFilename();
        String ext = "";
        if (original != null && original.contains(".")) ext = original.substring(original.lastIndexOf("."));

        String fileName = UUID.randomUUID().toString() + ext;
        Path target = Path.of(folder + fileName);

        try (InputStream in = file.getInputStream()) {
            Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
        }

        Map<String, String> resp = new HashMap<>();
        resp.put("url", "http://localhost:8082/icons/" + fileName);
        return resp;
    }

    @PostMapping("/owner/apps/{id}/icon")
    public Map<String, String> uploadIconForApp(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws Exception {
        Map<String, String> m = uploadIcon(file);
        String url = m.get("url");
        App app = service.find(id);
        if (app != null) {
            app.setIconUrl(url);
            service.save(app);
        }
        return m;
    }

    @PostMapping("/owner/apps")
    public App create(@RequestBody App a) {
        return service.save(a);
    }

    @PutMapping("/owner/apps/{id}")
    public App update(@PathVariable Long id, @RequestBody App newData) {
        App existing = service.find(id);
        if (existing == null) throw new RuntimeException("App not found");

        if (newData.getName() != null) existing.setName(newData.getName());
        if (newData.getDescription() != null) existing.setDescription(newData.getDescription());
        if (newData.getGenre() != null) existing.setGenre(newData.getGenre());
        if (newData.getVersion() != null) existing.setVersion(newData.getVersion());
        if (newData.getIconUrl() != null) existing.setIconUrl(newData.getIconUrl());
        if (newData.getVisible() != null) existing.setVisible(newData.getVisible());

        return service.save(existing);
    }

    @DeleteMapping("/owner/apps/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "deleted";
    }

    @GetMapping("/owner/apps/{ownerId}")
    public List<App> byOwner(@PathVariable Long ownerId) {
        return service.findByOwnerId(ownerId);
    }

    @PutMapping("/owner/apps/toggle/{id}")
    public App toggle(@PathVariable Long id) {
        App app = service.find(id);
        if (app == null) throw new RuntimeException("App not found");
        app.setVisible(!app.getVisible());
        return service.save(app);
    }

    @GetMapping("/apps/visible")
    public List<App> visibleApps() {
        return service.findVisibleApps();
    }

    @GetMapping("/owner/apps/search")
    public List<App> search(@RequestParam String q) {
        return service.searchVisibleApps(q);
    }

    @GetMapping("/apps/{id}")
    public App getApp(@PathVariable Long id) {
        return service.find(id);
    }
}
