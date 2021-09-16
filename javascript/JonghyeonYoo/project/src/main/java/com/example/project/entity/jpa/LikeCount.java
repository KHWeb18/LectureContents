package com.example.project.entity.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "likeCount")
public class LikeCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likeCount_no")
    private Long likeCountNo;

    @Column(length = 64, nullable = false)
    private Long userId;

    @Column(length = 20)
    private String isLike;

    @Column(length = 20)
    private String unLike;

    @Column(length = 64, nullable = false)
    private String movieNo;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;


}