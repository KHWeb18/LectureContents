package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Product {
    private int productNo;
    // th:field로 맵핑됨
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private String price;
}
