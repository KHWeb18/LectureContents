package com.example.demo.repository.jpa;


import com.example.demo.entity.jpa.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAMemberRepository extends JpaRepository<Member, Long> {

}
