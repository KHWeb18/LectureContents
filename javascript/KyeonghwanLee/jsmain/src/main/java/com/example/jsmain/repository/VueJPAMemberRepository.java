package com.example.jsmain.repository;

import com.example.jsmain.entity.VueMember;
import org.springframework.data.jpa.repository.JpaRepository;
//얘네는 DB에 row를 넣을 수 있게 해주는 용도이다.
public interface VueJPAMemberRepository extends JpaRepository<VueMember, Long> {

}