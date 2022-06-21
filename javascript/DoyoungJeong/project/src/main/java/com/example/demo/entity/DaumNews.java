package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
public class DaumNews {

    //여기에 있는 entity를 기반으로 db가 만들어진다!
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Id, GeneratedValue가 자동으로 db에서 private key를 auto-increment로 부여해줌
    private Long newsSeq;

    @Column(length = 20, nullable = false)
    private String newsNo;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String address;

    @Builder
    //자동으로 db에 있는 값을 가져와서 새로운 객체에 값을 부여해줌. setter를 쓰지않음
    public DaumNews(String newsNo, String category, String title, String address) {
        this.newsNo = newsNo;
        this.address = address;
        this.category = category;
        this.title = title;
    }

}
