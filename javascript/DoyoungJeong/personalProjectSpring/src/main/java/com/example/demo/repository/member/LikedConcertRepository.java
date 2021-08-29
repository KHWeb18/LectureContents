package com.example.demo.repository.member;

import com.example.demo.entity.member.LikedConcert;
import com.example.demo.entity.member.Member;
import com.example.demo.entity.member.MemberIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface LikedConcertRepository extends JpaRepository<LikedConcert, Long> {

    @Query("select lk from LikedConcert lk where lk.concertNo = :concertNo")
    Optional<LikedConcert> findByConcertNo(Long concertNo);

    Optional<LikedConcert> findByMemberNoAndConcertNo(Long memberNo, Long concertNo);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from LikedConcert lk where lk.concertNo = :concertNo and lk.memberNo = :memberNo")
    void deleteByConcertNo(Long concertNo, Long memberNo);

    @Query("select lk from LikedConcert lk where lk.memberNo = :memberNo and lk.concertNo != 0")
    List<LikedConcert> findByMemberNo(Long memberNo);

    @Transactional
    @Modifying(clearAutomatically = true) //탈퇴할 때 쓰는 전체 삭제
    @Query("delete from LikedConcert lk where lk.memberNo = :memberNo")
    void delete(Long memberNo);
}
