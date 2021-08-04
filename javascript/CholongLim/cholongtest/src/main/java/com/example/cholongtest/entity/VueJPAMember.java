package com.example.cholongtest.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
// JPA 사용 시 필수적인 Annotation이 Entity
@Entity
@Getter
@Setter
@ToString
public class VueJPAMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer membersNo;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 20, nullable = false)
    private Integer password;

    @Column(length = 20, nullable = false)
    private Integer phoneNum;

    @Column(length = 20, nullable = false)
    private Integer birth;

    @CreationTimestamp
    private LocalDateTime regDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;

}
