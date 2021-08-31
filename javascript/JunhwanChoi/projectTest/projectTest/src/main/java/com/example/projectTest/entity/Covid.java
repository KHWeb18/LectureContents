package com.example.projectTest.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@ToString
public class Covid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(length = 20, nullable = false)
    private String covidNo;

    @Column(length = 20, nullable = false)
    private String covidcategory;

    @Column(length = 20, nullable = false)
    private String totalCnt;

    @Column(length = 20, nullable = false)
    private String todayCnt;

    @Column(length = 20, nullable = false)
    private String clearCnt;

    @Column(length = 20, nullable = false)
    private String deathCnt;


    @Builder
    public Covid(String covidNo, String covidcategory, String totalCnt, String todayCnt, String clearCnt, String deathCnt) {
        this.covidNo = covidNo;
        this.covidcategory = covidcategory;
        this.totalCnt = totalCnt;
        this.todayCnt = todayCnt;
        this.clearCnt = clearCnt;
        this.deathCnt = deathCnt;
    }
}