package com.example.demo.entity.jpa;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "memeber")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 64, nullable = false)
    private String userId;

    @Column(length = 64, nullable = false)
    private String password;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
    //one to many  -> one 은 하나의 테이블인 member를 말한다.
    // 회원은 관리자,사업자, 개인 셋중에하나가 될수있다. 1:M
//    joincolumn
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<MemberAuth> authList = new ArrayList<MemberAuth>();

    public void addAuth(MemberAuth auth) {
        authList.add(auth);
    }
    public void clearAuthList() {
        authList.clear();
    }

    public Member(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

}
