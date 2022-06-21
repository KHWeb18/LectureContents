package com.example.demo.repository.member;

import com.example.demo.entity.member.Member;
import com.example.demo.entity.member.MemberIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

public interface MemberIdentityRepository extends JpaRepository<MemberIdentity, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from MemberIdentity mem where mem.memberNo = :memberNo")
    void delete(Long memberNo);

    @Transactional
    @Modifying
    @Query("update MemberIdentity mem set mem.identity = :identity where mem.memberNo = :memberNo")
    void modify(String identity, Long memberNo);

    @Query("select mem from MemberIdentity mem where mem.memberNo = :memberNo")
    Optional<MemberIdentity> findIdentityByMemberNo(Long memberNo);
}
