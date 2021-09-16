package com.example.jsmain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Board {
    private Integer boardNo;
    // th:field로 맵핑됨
    private String title;
    private String content;
    private String writer;
    private Date regDate;
}


// DIP(Dependency Inversion Principle)
// 의존성 역전 원칙을 지키면 Entity의 오염을 방지할 수 있음