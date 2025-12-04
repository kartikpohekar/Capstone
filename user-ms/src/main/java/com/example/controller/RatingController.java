package com.example.controller;

import com.example.entity.AppRating;
import com.example.repo.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingRepository repo;

	@PostMapping("/{appId}")
	public AppRating add(@PathVariable Long appId, @RequestBody AppRating r) {
		r.setAppId(appId);
		return repo.save(r);
	}

	@GetMapping("/{appId}")
	public List<AppRating> get(@PathVariable Long appId) {
		return repo.findByAppId(appId);
	}
}
