package com.example.jswithspring.repository;

import com.example.jswithspring.entity.VueMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueJPAMemberRepository extends JpaRepository<VueMember, Long> {
}