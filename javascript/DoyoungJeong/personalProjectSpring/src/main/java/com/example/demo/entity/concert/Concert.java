package com.example.demo.entity.concert;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="concert")
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "concert_no")
    private Long concertNo;

    @Column(length = 20, nullable = false)
    private String concertName;

    @Column(length = 20, nullable = false)
    private String concertArtist;

    @Column(length = 30, nullable = false)
    private String concertVenue;

    @Column(length = 10, nullable = false)
    private Integer venueCapacity;

    @Column(length = 25, nullable = false)
    private String concertPrice;

    @Column(length = 20, nullable = false)
    private String concertDate;

    @Column(nullable = false)
    private String concertInfo;

    @Column(nullable = true)
    private String numberOfLikes;

    @CreationTimestamp
    private Date regDate;
}
