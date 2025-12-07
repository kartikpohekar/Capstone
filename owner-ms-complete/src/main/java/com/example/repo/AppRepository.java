package com.example.repo;

import com.example.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AppRepository extends JpaRepository<App, Long> {

    List<App> findByOwnerId(Long ownerId);

    List<App> findByVisibleTrue();

    List<App> findByNameContainingIgnoreCaseAndVisibleTrue(String name);

    @Query("SELECT a.ownerId FROM App a WHERE a.id = :appId")
    Long findOwnerIdByAppId(@Param("appId") Long appId);
}
