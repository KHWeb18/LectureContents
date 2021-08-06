package com.example.cholongtest.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
// JPA 사용 시 필수적인 Annotation이 Entity
@Entity
@Getter
@Setter
@ToString
public class VueMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer membersNo;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private Integer phoneNum;

    @Column(length = 20, nullable = false)
    private Integer  memberBirth;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date lastModifiedDate;

}
