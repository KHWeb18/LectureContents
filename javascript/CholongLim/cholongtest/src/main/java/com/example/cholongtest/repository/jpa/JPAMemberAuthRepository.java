package com.example.cholongtest.repository.jpa;

import com.example.cholongtest.entity.jpa.Member;
import com.example.cholongtest.entity.jpa.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAMemberAuthRepository extends JpaRepository<MemberAuth, Long> {
}