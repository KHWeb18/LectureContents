package com.example.Quiz.entity.jpa;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@ToString
public class Member {
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
    public Member(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
