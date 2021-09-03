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
@Table(name="member_taste")
public class MemberTaste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_taste_no")
    private Long memberIdentityNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 100, nullable = false)
    private String chosenGenres;

    @Column(length = 20, nullable = false)
    private String speedTaste;

    @Column(length = 20, nullable = false)
    private String atmosphereTaste;

    @Column(length = 30, nullable = true)
    private String chosenArtists;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public MemberTaste(String chosenGenres, String speedTaste, String atmosphereTaste, String chosenArtists) {
        this.chosenGenres = chosenGenres;
        this.speedTaste = speedTaste;
        this.atmosphereTaste = atmosphereTaste;
        this.chosenArtists = chosenArtists;
    }

}
