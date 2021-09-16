package com.example.project.entity.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_no")
    private Long actorNo;

    @Column(length = 64, nullable = false)
    private String actorName;

    @Column(length = 50, nullable = false)
    private String movieNo;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;




}

