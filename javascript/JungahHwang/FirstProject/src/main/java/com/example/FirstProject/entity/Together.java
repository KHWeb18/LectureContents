package com.example.FirstProject.entity;

import com.example.FirstProject.request.RecommendDto;
import com.example.FirstProject.request.TogetherDto;
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
@Table(name = "together")
public class Together {

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

    @Column(length = 100)
    private String link;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public void updateTogether(TogetherDto togetherDto) {
        this.title = togetherDto.getTitle();
        this.content = togetherDto.getContent();
        this.link = togetherDto.getLink();
    }
}
























