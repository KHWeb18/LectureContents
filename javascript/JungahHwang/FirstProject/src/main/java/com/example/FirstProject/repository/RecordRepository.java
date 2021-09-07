package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RecordRepository extends JpaRepository<Record, Long> {

    Optional<Record> findByDate(String date);
}











