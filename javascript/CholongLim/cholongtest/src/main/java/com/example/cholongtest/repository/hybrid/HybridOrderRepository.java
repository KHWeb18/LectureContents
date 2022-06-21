package com.example.cholongtest.repository.hybrid;

import com.example.cholongtest.entity.hybrid.HybridOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HybridOrderRepository extends JpaRepository<HybridOrder, Long> {
}