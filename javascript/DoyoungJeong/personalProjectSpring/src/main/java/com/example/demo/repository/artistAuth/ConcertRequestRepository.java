package com.example.demo.repository.artistAuth;

import com.example.demo.entity.artistAuth.ConcertRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConcertRequestRepository extends JpaRepository<ConcertRequest, Long> {

    @Query("select cr from ConcertRequest cr where cr.concertRequestNo > 0 order by concertRequestNo asc") //엔티티에 이름 오류(복붙을 잘못해서 에러 났었음)
    List<ConcertRequest> getList();

    @Query("update ConcertRequest cr set cr.approvedOrNot = 'Y' where cr.concertRequestNo = :concertRequestNo")
    void updateApproveOrNot(Long concertRequestNo);
}
