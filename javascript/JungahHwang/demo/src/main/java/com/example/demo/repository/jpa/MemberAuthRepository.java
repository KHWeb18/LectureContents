package com.example.demo.repository.jpa;

import com.example.demo.entity.jpa.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberAuthRepository extends JpaRepository<MemberAuth, Long> {
}
