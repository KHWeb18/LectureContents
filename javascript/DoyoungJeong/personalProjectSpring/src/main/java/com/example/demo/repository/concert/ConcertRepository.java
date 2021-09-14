package com.example.demo.repository.concert;

import com.example.demo.entity.concert.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

      @Query("select co from Concert co where co.concertNo = :concertNo") //받는 자료형과 쿼리문 안에 from뒤 이름이 같아야한다!
      Optional<Concert> findByConcertNo(Long concertNo);

      @Transactional
      @Modifying(clearAutomatically = true, flushAutomatically = true)
      @Query("update Concert co set co.numberOfLikes = co.numberOfLikes + 1 where co.concertNo = :concertNo")
      void plusNumberOfLikes(Long concertNo);

      @Transactional
      @Modifying(clearAutomatically = true, flushAutomatically = true)
      @Query("update Concert co set co.numberOfLikes = co.numberOfLikes - 1 where co.concertNo = :concertNo")
      void minusNumberOfLikes(Long concertNo);

      @Transactional
      @Modifying(clearAutomatically = true, flushAutomatically = true)
      @Query("update Concert co set co.venueCapacity = co.venueCapacity - :numOfVisitors where co.concertNo = :concertNo")
      void minusVenueCapacity(Integer numOfVisitors, Long concertNo);

      @Transactional
      @Modifying(clearAutomatically = true, flushAutomatically = true)
      @Query("update Concert co set co.venueCapacity = co.venueCapacity + :numOfVisitors where co.concertNo = :concertNo")
      void plusVenueCapacity(Integer numOfVisitors, Long concertNo);
}
