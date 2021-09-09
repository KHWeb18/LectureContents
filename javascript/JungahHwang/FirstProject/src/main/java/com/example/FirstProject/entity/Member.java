package com.example.FirstProject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 50, nullable = false)
    private String id;

    @Column(length = 150, nullable = false)
    private String pw;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String birth;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String phone;

    @Column(length = 100, nullable = false)
    private String address;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;


//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "id")
//    private List<Record> recordList = new ArrayList<Record>();
//
//    public Member(String id, String pw, String name, String gender, String birth, String email, String phone, String address) {
//        this.id = id;
//        this.pw = pw;
//        this.name = name;
//        this.gender = gender;
//        this.birth = birth;
//        this.email = email;
//        this.phone = phone;
//        this.address = address;
//    }
//    public void addId(Record record) {
//        recordList.add(record);
//    }
//    public void clearRecordList () {
//        recordList.clear();
//    }
}














