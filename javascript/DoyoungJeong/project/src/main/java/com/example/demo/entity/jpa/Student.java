package com.example.demo.entity.jpa;

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
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_no")
    private Long studentNo;

    @Column(length = 20, nullable = false)
    private String studentId;

    @Column(length = 40, nullable = false)
    private String studentPw;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    //StudentGrade에 student_no를 join시키겠다는 뜻. Student객체는 1학년도 2학년도 3학년도 될 수 있다는 것이다!
    //한 Column을 다른 테이블에 더 자세하게 나눈다고 보면 될듯하다!

    //SNS의 관점에서본다면 팔로워 당한사람이 One이고 그 사람을 팔로잉한 다수의 사람들이 Many로 되는것이다!
    //Student라는 객체를 1학년, 2학년, 3학년 모두가 될 가능성이 있는 식별(OneToMany)을 진행
    //검사를 진행할 수 있게 해주는 기준(컬럼)은 student_no
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_no")

    private List<StudentGrade> gradeList = new ArrayList<StudentGrade>();

    public Student(String studentId, String studentPw) {
        this.studentId = studentId;
        this.studentPw = studentPw;
    }

    public void addGrade(StudentGrade grade) {
        gradeList.add(grade);
    } //grade에 해당하는 리스트 저장

    public void clearGradeList() {
        gradeList.clear();
    } //해당하지 않는 auth는 제거


}
