package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Product {
    private int productNo;
    private String product_name;
    private String description;
    private String producer;
    private int price;
    private Date regDate;
}