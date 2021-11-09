package com.example.market3.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Market {
    private String username;
    private int productNo;
    private String name;
    private String price;
    private String description;
    private Date regDate;

}

