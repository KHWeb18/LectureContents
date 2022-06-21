package com.example.miniProject.entity.jpa;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tourSeq;
    @Column(length = 20, nullable = false)
    private String tourNo;

    @Column(length = 500, nullable = false)
    private String category;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String address;


    @Builder
    public Tour(String newsNo, String title, String address, String category) {
        this.tourNo = newsNo;
        this.category = category;
        this.address = address;
        this.title = title;
    }
}
