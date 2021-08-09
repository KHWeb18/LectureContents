package com.example.personalProject.eutity.jpa;


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
@Table(name="test_member")
public class TestMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 64, nullable = false)
    private String id;

    @Column(length = 64, nullable = false)
    private String pw;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String sex;

    @Column(length = 20, nullable = false)
    private String phoneNo;

    @Column(length = 10, nullable = false)
    private String birth;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;

}
