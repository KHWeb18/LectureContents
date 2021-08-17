package com.example.miniProject.entity.jpa;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@ToString
public class Board {
    private Integer boardNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
}

