package com.example.miniProject.entity.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

public class Reservation {

    @Data
    @NoArgsConstructor
    @Entity
    @Table(name="reservation")
    public class Member {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "reserve_no")
        private Long reserveNo;

        @Column(length = 64, nullable = false)
        private String roomId;

        @Column(length = 64, nullable = false)
        private Integer maxNum;

        @Column(length = 64, nullable = false)
        private String userName;

        @Column(length = 64, nullable = false)
        private Integer userPhone;

        // 예약일자 - 8/15
        private Date reservedDate;

        @CreationTimestamp
        private Date regDate; // 예약을 언제했는지   - 7/30

        @UpdateTimestamp
        private Date updDate;
    }

}
