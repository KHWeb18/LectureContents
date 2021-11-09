package com.example.cholongtest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Product {
    private Integer productNo;
    private String title;
    private String price;
    private String content;
    private String writer;
    private Date regDate;
}
