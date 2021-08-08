package com.example.demo.entity.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "member_jpql")
public class MemberJPQL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 64, nullable = false)
    private String id;

    @Column(length = 64, nullable = false)
    private String pw;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}
