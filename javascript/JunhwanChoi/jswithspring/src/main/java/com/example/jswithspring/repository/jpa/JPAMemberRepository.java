package com.example.jswithspring.repository.jpa;

import com.example.jswithspring.entity.jpa.JpaMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAMemberRepository extends JpaRepository<JpaMember, Long> {
}