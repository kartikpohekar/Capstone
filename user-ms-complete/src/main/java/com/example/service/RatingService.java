package com.example.service;

import com.example.entity.AppRating;
import com.example.repo.AppRatingRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private AppRatingRepository repo;

    public AppRating save(AppRating r){
        return repo.save(r);
    }

    public List<AppRating> findByAppId(Long id){
        return repo.findByAppId(id);
    }

    // ⭐ NEW: Get average rating
    public double getAverageRating(Long appId){
        List<AppRating> ratings = repo.findByAppId(appId);
        if (ratings.isEmpty()) return 0;

        double sum = 0;
        for (AppRating r : ratings) {
            sum += r.getRating();
        }
        return sum / ratings.size();
    }

    // ⭐ NEW: Get total reviews count
    public long getReviewCount(Long appId){
        return repo.findByAppId(appId).size();
    }
}
