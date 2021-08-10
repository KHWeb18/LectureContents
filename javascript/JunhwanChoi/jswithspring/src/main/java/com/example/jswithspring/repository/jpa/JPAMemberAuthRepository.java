package com.example.jswithspring.repository.jpa;

import com.example.jswithspring.entity.jpa.Member;
import com.example.jswithspring.entity.jpa.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JPAMemberAuthRepository extends JpaRepository<MemberAuth, Long> {
}