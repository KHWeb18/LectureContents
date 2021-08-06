package com.example.jswithspring.repository.jpa;

import com.example.jswithspring.entity.jpa.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberAuthRepository extends JpaRepository<Member, Long> {
}