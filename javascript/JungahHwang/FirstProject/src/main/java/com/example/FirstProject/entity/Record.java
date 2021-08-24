package com.example.FirstProject.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "record_no")
    private Long recordNo;

    @Column(length = 50, nullable = false)
    private String id;

    @Column(length = 20, nullable = false)
    private String date;

    @Column(length = 100, nullable = true)
    private String food;

    @Column(length = 600, nullable = true)
    private String exercise;

    @Column(length = 30, nullable = true)
    private String weight;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @Builder
    public Record(String date, String food, String exercise, String weight) {
        this.date = date;
        this.exercise = exercise;
        this.food = food;
        this.weight = weight;
    }
}
