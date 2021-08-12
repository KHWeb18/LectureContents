package com.example.springTest.repository;

import com.example.springTest.entity.DaumNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaumNewsRepository extends JpaRepository<DaumNews, Long> {
    public DaumNews findByNewsNo(String newsNo);
}
