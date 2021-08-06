package com.example.cholongtest.repository.jpa;

import com.example.cholongtest.entity.jpa.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAMemberRepository extends JpaRepository<Member, Long> {
}