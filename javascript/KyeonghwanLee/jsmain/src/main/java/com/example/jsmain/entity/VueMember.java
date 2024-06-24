package com.example.jsmain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class VueMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberNo;

    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 20, nullable = false)
    private Integer pw;

    @Column(length = 20, nullable = false)
    private Integer phoneNo;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String address;

    @CreationTimestamp
    private Date createDate;

    @CreationTimestamp
    private Date lastModifiedDate;


}