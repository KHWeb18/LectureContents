package com.example.demo.controller.member.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LikedOrNotRequest {
    private Integer[] likedOrNotCheckNums;
}
