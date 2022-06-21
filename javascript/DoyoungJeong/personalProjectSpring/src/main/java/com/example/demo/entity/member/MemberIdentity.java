package com.example.demo.entity.member;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Data
@NoArgsConstructor
@Entity
@Table(name="member_identity")
public class MemberIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_identity_no")
    private Long memberIdentityNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 20, nullable = false)
    private String identity;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public MemberIdentity(String identity) {
        this.identity = identity;
    }
}
