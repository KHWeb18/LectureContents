package com.example.cholongtest.repository.jpa;

import com.example.cholongtest.entity.jpa.Member;
import com.example.cholongtest.entity.jpa.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JPAMemberAuthRepository extends JpaRepository<MemberAuth, Long> {

}