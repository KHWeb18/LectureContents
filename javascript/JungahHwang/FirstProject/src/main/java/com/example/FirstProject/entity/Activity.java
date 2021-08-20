package com.example.FirstProject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.nio.channels.Pipe;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "activity_no")
    private Long activityNo;

    @Column(length = 20, nullable = false)
    private String date;

    @Column(length = 10, nullable = false)
    private String activity;

    @Column(length = 600, nullable = false)
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}
