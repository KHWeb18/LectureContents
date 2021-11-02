package com.example.demo.repository;

import com.example.demo.eutity.DaumNews;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DaumNewsRepository extends JpaRepository<DaumNews, Long> {
    public DaumNews findByNewsNo(String newsNo);
}