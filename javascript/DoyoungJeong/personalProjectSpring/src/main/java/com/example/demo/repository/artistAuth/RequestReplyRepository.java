package com.example.demo.repository.artistAuth;

import com.example.demo.entity.artistAuth.RequestReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface RequestReplyRepository extends JpaRepository<RequestReply, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update RequestReply rr set rr.requestReply = :replyContent where rr.concertRequestNo = :concertRequestNo")
    void saveReply(String replyContent, Long concertRequestNo);

    @Query("select rr.requestReply from RequestReply rr where rr.concertRequestNo = :concertRequestNo")
    String findByConcertRequestNo(Long concertRequestNo);

    @Transactional
    @Modifying(clearAutomatically = true)
    void deleteByConcertRequestNo(Long concertRequestNo);
}
