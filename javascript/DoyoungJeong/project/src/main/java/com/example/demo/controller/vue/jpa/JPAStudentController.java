package com.example.demo.controller.vue.jpa;

import com.example.demo.controller.vue.jpa.request.StudentRequest;
import com.example.demo.entity.jpa.Student;
import com.example.demo.service.jpa.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/joincolumntest")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPAStudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/signup")
    public ResponseEntity<Void> jpaSignup(@Validated @RequestBody StudentRequest studentRequest) throws Exception {
        log.info("jpaSignup(): " + studentRequest.getStudentId() + ", " + studentRequest.getStudentPw() + ", " +
                studentRequest.getStudentGrade());

        service.register(studentRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    //얘는 굳이 클라이언트에서 실행 버튼을 만들어줬던 이유???
    @PostMapping("/test")
    public ResponseEntity<Void> jpaJPQLTest(Object number) throws Exception {
        log.info("jpaJPQLTest():");

        System.out.println(number); //이 오브젝트를 쪼개서 밑에 인자로 넣고싶은데 어떻게??? 인자에 PathVariable쓰면 된다.

        Optional<Student> maybeStudent = service.findByStudentNo(new Long(4)); //Long형이 아니면 안들어간다.
        Student student = maybeStudent.get(); //값이 조건에 맞는 리스트를 다 넣기때문에 ()안에 숫자가 없다.

        log.info("Number Info: " + student);
        log.info("The grade of this student is: " + student.getGradeList().get(0).getGrade());

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
