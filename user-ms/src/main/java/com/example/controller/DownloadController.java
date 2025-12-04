package com.example.controller;

import com.example.entity.Download;
import com.example.repo.DownloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/download")
public class DownloadController {

	@Autowired
	DownloadRepository repo;

	@PostMapping("/{appId}")
	public Download download(@PathVariable Long appId, @RequestBody Download d) {
		d.setAppId(appId);
		return repo.save(d);
	}
}
