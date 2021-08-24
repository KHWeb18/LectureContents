package com.example.miniProject.entity.jpa;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name="board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Long boardNo;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 150, nullable = false)
    private String writer;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

//    @CreatedDate
//    @Column(updatable = false)
//    private LocalDateTime createdDate;
//
//    @LastModifiedDate
//    private LocalDateTime modifiedDate;

    @Builder
    public Board(Long boardNo, String title, String writer, String content ) {
        this.boardNo = boardNo;
        this.title = title;
        this.writer = writer;
        this.content = content;

    }
}


