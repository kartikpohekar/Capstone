package com.example.repo;

import com.example.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppRepository extends JpaRepository<App, Long> {

    List<App> findByNameContainingIgnoreCase(String name);
    List<App> findByGenre(String genre);
}
