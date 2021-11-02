package com.example.Mini.entity.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Notice {
    private int boardNo;
    // th:field로 맵핑됨
    private String title;
    private String content;
    private String writer;
    private Date regDate;
}
