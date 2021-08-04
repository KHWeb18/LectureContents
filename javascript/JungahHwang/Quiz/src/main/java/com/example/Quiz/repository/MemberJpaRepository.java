package com.example.Quiz.repository;

import com.example.Quiz.entity.MemberJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberJpa, Long> {
}
