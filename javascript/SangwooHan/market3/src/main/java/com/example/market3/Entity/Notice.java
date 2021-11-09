package com.example.market3.Entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Notice {
            private  int boardNo;
            private  String title;
            private  String content;
            private  String name;
            private Date regDate;
            private  int views;


}
