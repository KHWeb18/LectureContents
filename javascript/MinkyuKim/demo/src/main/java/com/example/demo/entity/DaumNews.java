package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
// JPA 사용시 필수적인 Annotation이 Entity
@Entity
@ToString
public class DaumNews {
    // @id @generatedValue @column은 db를 자동으로 만드는 것. 그중 id는 고유한 값
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsSeq;

    // 길이가 20개 null 이 되면 안된다.
    @Column(length = 20, nullable = false)
    private String newsNo;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String address;

    // 자동으로 객체를 만들어주는 것
    // 필요에 따라 사용되는 생성자이며, 만약 누군가가 DaumNews를 요청하면 db를 가져오는것. 객체를 생성하는 것
    @Builder
    public DaumNews(String newsNo, String category, String title, String address) {
        this.newsNo = newsNo;
        this.address = address;
        this.category = category;
        this.title = title;
    }
}