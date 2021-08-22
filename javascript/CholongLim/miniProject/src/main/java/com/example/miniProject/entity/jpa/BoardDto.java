package com.example.miniProject.entity.jpa;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {

    private Long boardNo;
    private String title;
    private String writer;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Date regDate;
    private Date updDate;


    public Board toEntity() {
        Board build = Board.builder()
                .boardNo(boardNo)
                .title(title)
                .writer(writer)
                .content(content)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long boardNo, String title, String writer, String content, Date regDate, Date updDate) {

        this.boardNo = boardNo;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
        this.updDate = updDate;

    }
}
