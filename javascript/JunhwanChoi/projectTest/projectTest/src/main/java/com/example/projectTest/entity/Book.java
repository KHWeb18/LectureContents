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
    private Integer month;

    @Getter
    @Column(nullable = false)
    private Integer day;

    @Getter
    @Column(nullable = false)
    private Integer time;

    @Getter
    @Column(nullable = false)
    private String place;

    public Book(Integer month, Integer day, Integer time, String place) {
        this.month = month;
        this.day = day;
        this.time = time;
        this.place = place;
    }
}