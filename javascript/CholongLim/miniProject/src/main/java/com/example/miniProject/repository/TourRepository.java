package com.example.miniProject.repository;


import com.example.miniProject.entity.jpa.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
    public Tour findByTourNo(String tourNo);
}
