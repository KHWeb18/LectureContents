package com.example.springTest.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Product {
    private Integer productNo;
    private String product_name;
    private String description;
    private String producer;
    private Integer price;
    private Date regDate;
}