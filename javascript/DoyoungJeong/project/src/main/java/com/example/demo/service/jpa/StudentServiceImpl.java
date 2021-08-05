package com.example.demo.service.jpa;

import com.example.demo.controller.vue.jpa.request.StudentRequest;
import com.example.demo.entity.jpa.Student;
import com.example.demo.entity.jpa.StudentGrade;
import com.example.demo.repository.jpa.StudentGradeRepository;
import com.example.demo.repository.jpa.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentGradeRepository gradeRepository;

    @Override
    public void register(StudentRequest studentRequest) throws Exception {
        StudentGrade studentGrade = new StudentGrade(studentRequest.getStudentGrade());
        Student student = new Student(studentRequest.getStudentId(), studentRequest.getStudentPw());
        student.addGrade(studentGrade);

        repository.save(student);
    }
}
