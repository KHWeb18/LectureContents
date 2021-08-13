package com.example.demo.service.jpa;

import com.example.demo.controller.vue.jpa.request.StudentRequest;
import com.example.demo.entity.jpa.Student;
import com.example.demo.entity.jpa.StudentGrade;
import com.example.demo.repository.jpa.StudentGradeRepository;
import com.example.demo.repository.jpa.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentGradeRepository gradeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(StudentRequest studentRequest) throws Exception {
        String encodedPassword = passwordEncoder.encode(studentRequest.getStudentPw());
        studentRequest.setStudentPw(encodedPassword);
        //비밀번호 암호화

        StudentGrade studentGrade = new StudentGrade(studentRequest.getStudentGrade());
        Student student = new Student(studentRequest.getStudentId(), studentRequest.getStudentPw());
        student.addGrade(studentGrade);

        repository.save(student);
    }

    @Override
    public boolean login(StudentRequest studentRequest) throws Exception {
        Optional<Student> unsureGrade = repository.findByStudentId(studentRequest.getStudentId());

        if(unsureGrade == null) {
            log.info("Not Existed ID!");
            return false;
        }

        //Student loginStudent = unsureGrade.get(); 이렇게 말고, passwordEncoder로 복호화해서 match로 비교!
        if(!passwordEncoder.matches(studentRequest.getStudentPw(), unsureGrade.get().getStudentPw())) { //이렇게 해도 됨
            log.info("Wrong Password!");
            return false;
        }
        return true;
    }

    @Override
    public boolean checkStudentIdValidation(String studentId) throws Exception {
        Optional<Student> maybeStudent = repository.findByStudentId(studentId);
        log.info("maybeStudent: " + maybeStudent);

        if(maybeStudent == null) {
            log.info("login(): Not Existed ID");
            return false;
        } else {
            log.info("maybeStudent: " + maybeStudent);
            return true;
        }
    }

    @Override
    public Optional<Student> findByStudentNo(Long studentNo) {
        return repository.findByStudentNo(studentNo);
    }

}
