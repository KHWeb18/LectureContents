package com.example.cholongtest.repository;

import com.example.cholongtest.entity.VueMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueJPAMemberRepository extends JpaRepository<VueMember, Long> {
}
