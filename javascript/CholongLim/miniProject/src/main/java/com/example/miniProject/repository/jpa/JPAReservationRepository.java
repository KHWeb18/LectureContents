package com.example.miniProject.repository.jpa;


import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.entity.jpa.Reservation;
import com.example.miniProject.entity.jpa.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface JPAReservationRepository extends JpaRepository<Reservation, Long> {

//    @Query("select e from Reservation e where e.reservedDate = :reservedDate")
//    Optional<Reservation> findByDate(Date reservedDate);

    @Query("select e from Reservation e where e.reservedDate = :reservedDate")
    List<Reservation> findByDate(Date reservedDate);

    @Query("select e from Reservation e where e.bookNo = :bookNo")
    Optional<Reservation> findByBookNo(Long bookNo);

    @Query
    List<Reservation> findByBookNoContaining(Long bookNo);

}
