package com.example.demo.repository.artistAuth;

import com.example.demo.entity.artistAuth.ConcertRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ConcertRequestRepository extends JpaRepository<ConcertRequest, Long> {

    @Query("select cr from ConcertRequest cr where cr.concertRequestNo > 0 order by concertRequestNo asc") //엔티티에 이름 오류(복붙을 잘못해서 에러 났었음)
    List<ConcertRequest> getList();

    @Query("select cr from ConcertRequest cr where cr.concertRequestNo = :concertRequestNo")
    Optional<ConcertRequest> findByConcertRequestNo(Long concertRequestNo);

    List<ConcertRequest> findByMemberNo(Long memberNo);

    @Transactional
    @Modifying
    @Query("update ConcertRequest cr set cr.approvedOrNot = 'Y' where cr.concertRequestNo = :concertRequestNo")
    void approveConcertRequest(Long concertRequestNo);

    @Transactional
    @Modifying
    @Query("update ConcertRequest cr set cr.approvedOrNot = 'N' where cr.concertRequestNo = :concertRequestNo")
    void denyConcertRequest(Long concertRequestNo);

    @Transactional
    @Modifying
    @Query("update ConcertRequest cr set cr.approvedOrNot = 'A' where cr.concertRequestNo = :concertRequestNo")
    void deferConcertRequest(Long concertRequestNo);

    @Transactional
    @Modifying
    @Query("update ConcertRequest cr set cr.regName = :regName, cr.artistName = :artistName, cr.venueName = :venueName, " +
            "cr.concertName = :concertName, cr.dateOfConcert = :dateOfConcert, cr.timeOfConcert = :timeOfConcert, cr.approvedOrNot = 'R' " +
            "where cr.concertRequestNo = :concertRequestNo")
    void modifyConcertRequest(String regName, String artistName, String venueName, String concertName, Date dateOfConcert, String timeOfConcert,
                              Long concertRequestNo);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update ConcertRequest cr set cr.regName = '탈퇴한 회원' where cr.memberNo = :memberNo") //탈퇴한 회원이 작성한 보드의 id 바꿔줌.
    void makeIdAsWithdrawn(Long memberNo);

    @Transactional
    @Modifying(clearAutomatically = true)
    void deleteByConcertRequestNo(Long concertRequestNo);
}
