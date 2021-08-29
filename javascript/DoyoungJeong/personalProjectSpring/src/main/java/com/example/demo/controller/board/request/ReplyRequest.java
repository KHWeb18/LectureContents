package com.example.demo.controller.board.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyRequest {

    private Integer boardNo;
    private String id;
    private String content;
}
