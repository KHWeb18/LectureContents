package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MapRepository extends JpaRepository<Map, Long> {
    Optional<Map> findByBoardNo(Long boardNo);
}
