package com.example.demo.entity.crawling;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
public class IndieNews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsSeq;

    @Column(length = 20, nullable = false)
    private String newsNo;

    @Column(length = 20, nullable = false)
    private String keyword;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String address;

    @Builder
    public IndieNews(String newsNo, String keyword, String title, String address) {
        this.newsNo = newsNo;
        this.keyword = keyword;
        this.title = title;
        this.address = address;
    }
}
