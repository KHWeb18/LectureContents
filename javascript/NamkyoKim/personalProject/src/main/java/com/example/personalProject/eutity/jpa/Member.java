package com.example.personalProject.eutity.jpa;


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
@Table(name="member")
public class Member {
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


    /* Join Column 파트 */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<MemberAuth> authList = new ArrayList<MemberAuth>();

    public Member(String id, String pw, String name, String sex, String phoneNo, String birth){
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.sex = sex;
        this.phoneNo = phoneNo;
        this.birth = birth;

    }

    public void addAuth(MemberAuth auth){
        authList.add(auth);
    }

    public void clearAuthList (){
        authList.clear();
    }

}
