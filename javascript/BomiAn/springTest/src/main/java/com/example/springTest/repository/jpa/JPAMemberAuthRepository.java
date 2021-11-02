package com.example.springTest.repository.jpa;

import com.example.springTest.entity.jpa.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAMemberAuthRepository extends JpaRepository<MemberAuth, Long> {
}
