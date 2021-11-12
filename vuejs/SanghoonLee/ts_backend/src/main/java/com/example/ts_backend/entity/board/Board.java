package com.example.ts_backend.entity.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
//@Table(name="board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Long boardNo;

    @Column(length = 64, nullable = false)
    private String title;

    @Column(length = 64, nullable = false)
    private String writer;

    @Column(columnDefinition = "TEXT")
    private String content;

    @CreationTimestamp
    private Date regDate;
}
