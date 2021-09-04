package com.example.project.repository;

import com.example.project.entity.DaumNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaumNewsRepository extends JpaRepository<DaumNews, Long> {
     DaumNews findByNewsNo(String newsNo);
}