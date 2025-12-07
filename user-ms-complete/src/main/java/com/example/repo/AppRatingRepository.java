package com.example.repo;
import com.example.entity.AppRating;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppRatingRepository extends JpaRepository<AppRating,Long> {
    List<AppRating> findByAppId(Long appId);
}
