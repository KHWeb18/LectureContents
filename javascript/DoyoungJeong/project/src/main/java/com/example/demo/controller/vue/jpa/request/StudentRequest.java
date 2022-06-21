package com.example.demo.controller.vue.jpa.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentRequest {
    private String studentId;
    private String studentPw;
    private String StudentGrade;
}
