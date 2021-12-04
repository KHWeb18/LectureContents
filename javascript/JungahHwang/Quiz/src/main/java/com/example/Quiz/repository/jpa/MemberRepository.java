package com.example.Quiz.repository.jpa;

import com.example.Quiz.entity.jpa.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
