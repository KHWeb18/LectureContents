package com.example.FirstProject.entity;


import com.example.FirstProject.request.RecordDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    private Long weight;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public void updateRecord(RecordDto recordDto) {
        this.food = recordDto.getFood();
        this.exercise = recordDto.getExercise();
        this.weight = recordDto.getWeight();
    }
}
