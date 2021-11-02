package com.example.SoloProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Product {
    private Integer productNo;
    private String name;
    private Integer price;
    private String description;
    private String writer;
    private Date regDate;
}
