package com.example.SoloProject.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Board {
    private Integer boardNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
}
