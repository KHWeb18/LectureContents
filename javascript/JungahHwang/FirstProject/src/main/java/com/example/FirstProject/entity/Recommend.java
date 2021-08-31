package com.example.FirstProject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
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

    @Column(length = 50000, nullable = false)
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public Recommend(Long boardNo, String id, String title, String content) {
        this.boardNo = boardNo;
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
























