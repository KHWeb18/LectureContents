package com.example.demo.entity;

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
@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 64, nullable = false)
    private String userId;

    @Column(length = 64, nullable = false)
    private String password;

    @Column(length = 64, nullable = false)
    private String name;

    @Column(length = 64, nullable = false)
    private Integer dateOfBirth;

    @Column(length = 64, nullable = false)
    private Integer phoneNumber;

    @Column(length = 64, nullable = false)
    private String email;

    @Column(length = 64, nullable = false)
    private String address;

    @Column(name="gender", nullable = false)
    private String gender;

    @Column
    private String drawing;

    @Column
    private String article;

    @Column
    private String largeArtwork;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;


    /* Join Column 파트 */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<MemberAuth> authList = new ArrayList<MemberAuth>();

    public Member(String userId, String password, String name, Integer dateOfBirth, Integer phoneNumber, String email,
                  String address, String gender, String drawing, String article, String largeArtwork) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.drawing = drawing;
        this. article = article;
        this.largeArtwork = largeArtwork;
    }

    public void addAuth(MemberAuth auth) {
        authList.add(auth);
    }

    public void clearAuthList () {
        authList.clear();
    }
}