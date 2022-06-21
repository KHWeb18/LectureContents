package com.example.cholongtest.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
// JPA 사용 시 필수적인 Annotation이 Entity
@Entity
@ToString
public class DaumNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsSeq;

    @Column(length = 20, nullable = false)
    private String newsNo;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String address;

    // 필요에 따라 사용하는 생성자
    // 필요없을때 빌더가 없어도 상관없다
    // 현재 다음 뉴스에서는 없어서 작동한다.
    @Builder
    public DaumNews(String newsNo, String category, String title, String address) {
        this.newsNo = newsNo;
        this.address = address;
        this.category = category;
        this.title = title;
    }
}
