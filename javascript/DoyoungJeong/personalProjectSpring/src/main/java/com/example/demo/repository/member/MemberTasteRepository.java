package com.example.demo.repository.member;

import com.example.demo.entity.member.Member;
import com.example.demo.entity.member.MemberTaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

public interface MemberTasteRepository extends JpaRepository<MemberTaste, Long> {

    @Transactional
    @Modifying
    @Query("delete from MemberTaste mem where mem.memberNo = :memberNo")
    void delete(Long memberNo);

    @Transactional //굳이 안해줘도 될것같음
    @Modifying
    @Query("delete from MemberTaste mem where mem.memberNo = :memberNo and mem.speedTaste = 'default'")
    void deleteDefault(Long memberNo);

    @Query("select mem from MemberTaste mem where mem.memberNo = :memberNo and mem.speedTaste != 'default'")
    Optional<MemberTaste> isTasteThatExists(Long memberNo);

    @Transactional
    @Modifying
    @Query("update MemberTaste mem set mem.chosenGenres = :chosenGenres, mem.speedTaste = :speedTaste, mem.atmosphereTaste = :atmosphereTaste, " +
            "mem.chosenArtists = :chosenArtists where mem.memberNo = :memberNo")
    void updateTaste(String chosenGenres, String speedTaste, String atmosphereTaste, String chosenArtists, Long memberNo);

}
