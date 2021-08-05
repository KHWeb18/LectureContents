package com.example.demo.entity.jpa;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "member_auth")
public class MemberAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberAuth;

    @Column(name = "member_no")
    private Long memeberNo;

    @Column(length = 64, nullable = false)
    private String auth;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;

    public MemberAuth(String auth) {
        this.auth = auth;
    }


}
