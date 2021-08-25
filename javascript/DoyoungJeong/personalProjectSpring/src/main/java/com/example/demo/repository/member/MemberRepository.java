package com.example.demo.repository.member;

import com.example.demo.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select mem from Member mem where mem.id = :id")
    Optional<Member> findByMemberId(String id);

    @Query("select mem from Member mem where mem.memberNo > 0 order by memberNo asc") //여기 쿼리문 제대로 안써주면 에러가난다..
    List<Member> getList();

    @Transactional
    @Modifying
    @Query("delete from Member mem where mem.memberNo = :memberNo")
    void delete(Long memberNo);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Member mem set mem = :member where mem.memberNo = :memberNo")
    void modify(Member member, Long memberNo) throws Exception;
    
    //회원 정보 업데이트 구현 중...
//    @Modifying
//    @Query("UPDATE Member mem set mem.id = ?1, mem.password = ?2, mem.name = ?3, mem.location = ?4, mem.birthDay = ?5, " +
//            "mem.phoneNo = ?6 where mem.memberNo = :memberNo")
//    void modify(String id, String password, String name, String location, Date birthday, String phoneNo, Long memberNo);
}
