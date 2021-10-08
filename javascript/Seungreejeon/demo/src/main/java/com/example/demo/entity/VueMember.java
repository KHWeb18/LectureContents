package com.example.demo.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

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
    private Integer memeberNo;

    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 20, nullable = false)
    private String pw;

//    @CreatedDate
    @CreationTimestamp
    private Date createdDate;

//    @LastModifiedBy
    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;

}
