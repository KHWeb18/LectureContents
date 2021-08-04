package com.example.Quiz.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@ToString
public class MemberJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNo;

    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 30, nullable = false)
    private String pw;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

    @Builder
    public MemberJpa(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
