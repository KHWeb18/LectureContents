package com.example.demo.controller.board.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyModifyRequest {

    private Integer replyNo;
    private String content;
}
