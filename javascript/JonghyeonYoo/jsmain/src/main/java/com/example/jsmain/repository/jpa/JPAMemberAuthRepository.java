package com.example.jsmain.repository.jpa;

import com.example.jsmain.entity.jpa.Member;
import com.example.jsmain.entity.jpa.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAMemberAuthRepository extends JpaRepository<MemberAuth, Long> {
}