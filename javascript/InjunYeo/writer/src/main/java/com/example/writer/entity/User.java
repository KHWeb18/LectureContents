package com.example.writer.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;


@Getter
@Setter
@ToString

public class User {

    private int userNo;
    private String id;
    private String pw;
    private Date regDate;
}
