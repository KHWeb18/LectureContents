package com.example.projectTest.repository;

import com.example.projectTest.entity.Covid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CovidRepository extends JpaRepository<Covid, Long> {
    public Covid findBycovidNo(String covidNo);
}