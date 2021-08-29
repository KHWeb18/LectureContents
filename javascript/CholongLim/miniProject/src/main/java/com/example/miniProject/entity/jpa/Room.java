package com.example.miniProject.entity.jpa;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
    @NoArgsConstructor
    @Entity
    @Table(name="rooms")
    public class Room {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)


        @Column(name = "room_no")
        private Long roomNo;

        @Column(length = 64, nullable = false)
        private String roomId;

        @Column(length = 64, nullable = false)
        private String period;

        @Column(length = 64, nullable = false)
        private String personNum;

        @Column(length = 64, nullable = false)
        private String bankName;

        @Column(length = 64, nullable = false)
        private String price;

        @Column(length = 64, nullable = false)
        private Integer roomCnt;


//        public Room(String roomId) {
//        this.roomId = roomId;
//        }


    }


