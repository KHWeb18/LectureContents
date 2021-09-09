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
@Table(name="liked_concert")
public class LikedConcert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "liked_concert_no")
    private Long likedConcertNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 20, nullable = false)
    private Long concertNo;

    @Column(length = 20, nullable = false)
    private String concertName;

    @Column(length = 20, nullable = false)
    private String concertArtist;

    @Column(length = 30, nullable = false)
    private String concertVenue;

    @Column(length = 25, nullable = false)
    private String concertPrice;

    @Column(length = 20, nullable = false)
    private String concertDate;

    @Column(nullable = false)
    private String concertInfo;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public LikedConcert(Long concertNo, String concertName, String concertArtist, String concertVenue, String concertPrice, String concertDate, String concertInfo) {
        this.concertNo = concertNo;
        this.concertName = concertName;
        this.concertArtist = concertArtist;
        this.concertVenue = concertVenue;
        this.concertPrice = concertPrice;
        this.concertDate = concertDate;
        this.concertInfo = concertInfo;
    }
}
