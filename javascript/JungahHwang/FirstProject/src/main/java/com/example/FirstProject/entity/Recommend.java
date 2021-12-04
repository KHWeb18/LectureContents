package com.example.FirstProject.entity;

import com.example.FirstProject.request.RecommendDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recommend")
public class Recommend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "board_no")
    private Long boardNo;

    @Column(length = 60, nullable = false)
    private String id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 10000, nullable = false)
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public void updateRecommend(RecommendDto recommendDto) {
        this.title = recommendDto.getTitle();
        this.content = recommendDto.getContent();
    }
}
























