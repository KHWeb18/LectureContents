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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "member_no")
    private Set<MemberTaste> memberTasteList = new HashSet<MemberTaste>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "member_no")
    private Set<BookedConcert> bookedConcertList = new HashSet<BookedConcert>();

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//    @JoinColumn(name = "member_no")
//    private Set<Board> boardContentList = new HashSet<Board>();

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
    //얘는 가입할 때 같이 입력하니까.. 회원 가입할 때 같이 넣어주지만 나머지는 필요 없는듯..
    //지금 보니까 이 add는 처음에 같이 넣어주는거 아니면 필요가 없네... ㅋㅋ
    //나중에 지우자

    public void addLikedConcert(LikedConcert likedConcert) {
        likedConcertList.add(likedConcert);
    }

    public void addMemberTaste(MemberTaste memberTaste) {
        memberTasteList.add(memberTaste);
    }

    public void addBookedConcert(BookedConcert bookedConcert) {
        bookedConcertList.add(bookedConcert);
    }

    public void clearMemberIdentityList(){
        memberIdentityList.clear();
    }
}
