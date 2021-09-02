package com.example.miniProject.repository.jpa;


import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.entity.jpa.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface JPARoomRepository extends JpaRepository<Room, Long> {

    @Query("select r from Room r where r.userId = :userId")
    Optional<Room> findByUserInfo(String userId);

    @Query("select r from Room r where r.roomId = :roomId")
    Optional<Room> findByRoomId(String roomId);

}
