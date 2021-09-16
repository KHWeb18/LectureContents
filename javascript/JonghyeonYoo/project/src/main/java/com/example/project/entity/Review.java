package com.example.project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Review {
    private Integer reviewNo;
    // th:field로 맵핑됨

    private String writer;
    private String content;
    private Date regDate;
    private Date updDate;
}
