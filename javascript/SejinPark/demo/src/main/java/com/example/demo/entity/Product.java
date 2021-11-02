package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Product {
    private Integer productNo;
    private String product_name;
    private String description;
    private String producer;
    private int price;
    private Date regDate;
}