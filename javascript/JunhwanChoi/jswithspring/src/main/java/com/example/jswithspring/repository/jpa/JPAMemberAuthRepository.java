package com.example.jswithspring.repository.jpa;

import com.example.jswithspring.entity.jpa.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAMemberAuthRepository extends JpaRepository<MemberAuth, Long> {
}