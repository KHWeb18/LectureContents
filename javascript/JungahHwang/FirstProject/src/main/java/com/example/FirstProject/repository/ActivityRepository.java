package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query("select a from Activity a where a.date = :date")
    Optional<Activity> findByDate(String date);
}
