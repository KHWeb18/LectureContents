package com.example.demo.repository.jpa;

import com.example.demo.entity.jpa.DaumNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaumNewsRepository extends JpaRepository<DaumNews, Long> {
    public DaumNews findByNewsNo(String newsNo);
}
