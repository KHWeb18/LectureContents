package com.example.jsmain.repository;

import com.example.jsmain.entity.VueMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueJPAMemberRepository extends JpaRepository<VueMember, Long> {
}