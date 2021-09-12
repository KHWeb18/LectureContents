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

    @Getter
    @Column(nullable = false)
    private String start;


    @Getter
    @Column(nullable = false)
    private String time;

    @Getter
    @Column(nullable = false)
    private String title;

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