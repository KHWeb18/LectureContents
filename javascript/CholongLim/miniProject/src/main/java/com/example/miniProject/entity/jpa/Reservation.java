package com.example.miniProject.entity.jpa;

import jdk.jfr.Timestamp;
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
    @Table(name="reservation")
    public class Reservation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long reservationNo;

        @Column(name = "room_no")
        private Long roomNo;

        @Column(length = 64, nullable = false)
        private String roomId;

        @Temporal(TemporalType.DATE)
        private Date reservedDate;

        @CreationTimestamp
        private Date regDate; // 예약을 언제했는지   - 7/30

        @UpdateTimestamp
        private Date updDate;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinColumn(name = "room_no")
        private List<Room> roomList = new ArrayList<Room>();

        public Reservation(Date reservedDate) {
            this.reservedDate = reservedDate;
        }

        public void addRoom(Room room) {
            roomList.add(room);
        }

        public void clearRoomList () {
            roomList.clear();
        }


    }

