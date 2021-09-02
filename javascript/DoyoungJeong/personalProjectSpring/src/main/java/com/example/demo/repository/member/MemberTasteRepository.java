package com.example.demo.repository.member;

import com.example.demo.entity.member.Member;
import com.example.demo.entity.member.MemberTaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MemberTasteRepository extends JpaRepository<MemberTaste, Long> {

    @Transactional
    @Modifying
    @Query("delete from MemberTaste mem where mem.memberNo = :memberNo")
    void delete(Long memberNo);

    @Transactional
    @Modifying
    @Query("delete from MemberTaste mem where mem.memberNo = :memberNo")
    void deleteDefault(Long memberNo);
}
