package com.example.demo.repository.member;

import com.example.demo.entity.member.Member;
import com.example.demo.entity.member.MemberIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MemberIdentityRepository extends JpaRepository<MemberIdentity, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from MemberIdentity mem where mem.memberNo = :memberNo")
    void delete(Long memberNo);
}
