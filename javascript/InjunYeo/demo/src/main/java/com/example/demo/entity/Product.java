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
    private String name;
    private String price;
    private String producer;
    private String description;
    private Date regDate;
}
