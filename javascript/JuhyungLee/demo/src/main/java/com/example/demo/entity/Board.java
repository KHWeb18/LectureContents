package com.example.demo.entity;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
// lombok 쓰면
// getter/setter 간단하게 어노테이션으로 끝.
@Getter
@Setter
public class Board {
    private int boardNo;
    // th:field로 맵핑됨
    private String title;
    private String content;
    private String writer;
    private Date regDates;
}
