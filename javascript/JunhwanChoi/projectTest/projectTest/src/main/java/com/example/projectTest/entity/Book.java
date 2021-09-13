package com.example.projectTest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Entity
@Table
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookNo;

    //날짜
    @Getter
    @Column(nullable = false)
    private String start;

    //시간
    @Getter
    @Column(nullable = false)
    private String time;

    //장소
    @Getter
    @Column(nullable = false)
    private String title;

    //예약자 이름
    @Getter
    @Column(nullable = false)
    private String name;

    public Book(String start, String time, String title, String name) {
        this.start = start;
        this.time = time;
        this.title = title;
        this.name = name;
    }
}