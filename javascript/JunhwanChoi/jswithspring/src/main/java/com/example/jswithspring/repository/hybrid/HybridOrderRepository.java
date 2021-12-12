package com.example.jswithspring.repository.hybrid;

import com.example.jswithspring.entity.hybrid.HybridOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HybridOrderRepository extends JpaRepository<HybridOrder, Long> {
}