package com.example.demo.repository.member;

import com.example.demo.entity.member.BookedConcert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BookedConcertRepository extends JpaRepository<BookedConcert, Long> {

    @Transactional
    @Modifying(clearAutomatically = true) //탈퇴할 때 쓰는 전체 삭제
    @Query("delete from BookedConcert bc where bc.memberNo = :memberNo")
    void delete(Long memberNo);

    Optional<BookedConcert> findByMemberNoAndConcertNo(Long memberNo, Long concertNo);

    Optional<BookedConcert> findByBookedConcertNo(Long bookedConcertNo);

    List<BookedConcert> findByMemberNo(Long memberNo);

    @Transactional
    @Modifying(clearAutomatically = true) //예약 사항 변경
    @Query("update BookedConcert bc set bc.name = :name, bc.phoneNumber = :phoneNumber, bc.numOfVisitors = :numOfVisitors, bc.message = :message " +
            "where bc.bookedConcertNo = :bookedConcertNo")
    void alterBooking(String name, String phoneNumber, Integer numOfVisitors, String message, Long bookedConcertNo);

    @Transactional
    @Modifying(clearAutomatically = true)
    void deleteByBookedConcertNo(Long bookedConcertNo);
}
