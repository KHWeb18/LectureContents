package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.id = :id")
    Optional<Member> findById(String id);

//    @Query("select m from Member m join fetch m.recordList where m.id = :id")
//    Optional<Member> findByRecord(String id);

}
