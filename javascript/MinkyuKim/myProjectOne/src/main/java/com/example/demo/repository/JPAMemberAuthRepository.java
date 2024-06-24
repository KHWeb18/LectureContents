package com.example.demo.repository;

import com.example.demo.entity.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAMemberAuthRepository extends JpaRepository<MemberAuth, Long> {
}