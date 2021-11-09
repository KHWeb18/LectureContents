package com.example.springTest.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class DaumNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long newsSeq;

    @Column(length = 20, nullable = false)
    private String newsNo;
    @Column(length = 20, nullable = false)
    private String category;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(length = 2000, nullable = false)
    private String address;

    @Builder
    private DaumNews(String newsNo, String category, String title, String address) {
        this.newsNo = newsNo;
        this.address = address;
        this.category = category;
        this.title = title;
    }
}
