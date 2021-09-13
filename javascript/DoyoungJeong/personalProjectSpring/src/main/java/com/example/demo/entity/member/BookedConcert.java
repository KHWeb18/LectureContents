package com.example.demo.entity.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="booked_concert")
public class BookedConcert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booked_concert_no")
    private Long bookedConcertNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 20, nullable = false)
    private Long concertNo;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String concertName;

    @Column(length = 20, nullable = false)
    private String phoneNumber;

    @Column(length = 30, nullable = false)
    private Integer numOfVisitors;

    @Column(length = 80, nullable = true)
    private String message;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}
