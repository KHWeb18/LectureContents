package com.example.jsmain.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
// JPA 사용시 필수적인 Annotation이 Entity
@Entity
@ToString
public class DaumNews {
    @Id//primary 유일한 키를 설정할떄 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrement 역할을한다.
    private Long newsSeq;

    @Column(length = 20, nullable = false)
    private String newsNo;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String address;

    @Builder//daumnews를 호출시에 적절하게 사용하게해줌 -생성자 객체를 새로 가져온다.
    public DaumNews(String newsNo, String category, String title, String address) {
        this.newsNo = newsNo;
        this.address = address;
        this.category = category;
        this.title = title;
    }
}