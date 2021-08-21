package com.example.demo.entity.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="student_grade")
public class StudentGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_grade_no")
    private Long studentGradeNo;

    @Column(name = "student_no") //Student객체의 "student_no"와 join되어 공유되는 column
    private Long studentNo;

    @Column(length = 10, nullable = false)
    private String grade;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;


    public StudentGrade(String grade) {
        this.grade = grade;
    }
}
