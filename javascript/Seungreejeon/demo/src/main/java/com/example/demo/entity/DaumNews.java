package com.example.demo.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor

// JPA 사용시 필수적인 Annotation이  Enitity
@Entity
@ToString
public class DaumNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //자동증가형식으로 아이디를 준다. auto_increment

    private Long newsSeq;

    @Column(length = 20, nullable = false)
    private String newsNo;
    //길이 20개 null값 false로 허용안함
    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String address;

    //builder 자동으로 객체를 만들어주거나 새로 생성
    //요청이있다면 만들어준다. setter와 유사
    @Builder
    public DaumNews(String newsNo, String category, String title, String address) {
        this.newsNo = newsNo;
        this.address = address;
        this.category = category;
        this.title = title;
    }
}
