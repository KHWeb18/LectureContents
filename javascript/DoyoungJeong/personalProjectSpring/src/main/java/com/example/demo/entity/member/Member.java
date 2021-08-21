package com.example.demo.entity.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="member")
@Transactional
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 100, nullable = false)
    private String id;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String location;

    @Column(length = 20, nullable = false)
    private Date birthDay;

    @Column(nullable = false)
    private String phoneNo;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "member_no")
    private Set<MemberIdentity> memberIdentityList = new HashSet<MemberIdentity>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "member_no")
    private Set<LikedConcert> likedConcertList = new HashSet<LikedConcert>();

    public Member(String id, String password, String name, String location, Date birthDay, String phoneNo) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.location = location;
        this.birthDay = birthDay;
        this.phoneNo = phoneNo;
    }

    public void addIdentity(MemberIdentity memberIdentity) {
        memberIdentityList.add(memberIdentity);
    }

    public void addLikedConcert(LikedConcert likedConcert) {
        likedConcertList.add(likedConcert);
    }

    public void clearMemberIdentityList(){
        memberIdentityList.clear();
    }
}
