package com.example.miniProject.repository.jpa;


import com.example.miniProject.entity.jpa.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JPAReservationRepository extends JpaRepository<Reservation, Long> {

}
