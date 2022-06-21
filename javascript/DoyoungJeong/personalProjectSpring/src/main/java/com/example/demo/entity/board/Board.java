package com.example.demo.entity.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="board") //이 엔티티가 데이터 스키마 역할을 하는것이다.
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Long boardNo;

//    @Column(name = "member_no")
//    private Long memberNo;

    @Column(length = 100, nullable = false)
    private String id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 300, nullable = false)
    private String content;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "board_no")
    private Set<BoardReply> boardReplyList = new HashSet<BoardReply>();

    public Board(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void addBoardReply(BoardReply boardReply) {
        boardReplyList.add(boardReply);
    }

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}
