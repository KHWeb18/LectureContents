package com.example.demo.controller.vue.jpa;

import com.example.demo.controller.vue.jpa.request.StudentRequest;
import com.example.demo.controller.vue.session.UserInfo;
import com.example.demo.entity.jpa.Student;
import com.example.demo.service.jpa.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/joincolumntest")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPAStudentController {

    @Autowired
    private StudentService service;

    private UserInfo info;

    private HttpSession session;

    @PostMapping("/signup")
    public ResponseEntity<Void> jpaSignup(@Validated @RequestBody StudentRequest studentRequest) throws Exception {
        log.info("jpaSignup(): " + studentRequest.getStudentId() + ", " + studentRequest.getStudentPw() + ", " +
                studentRequest.getStudentGrade());

        service.register(studentRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    //얘는 굳이 클라이언트에서 실행 버튼을 만들어줬던 이유???
    @PostMapping("/test/{number}")
    public ResponseEntity<Void> jpaJPQLTest(@PathVariable("number") Integer number) throws Exception {
        log.info("jpaJPQLTest():" + number);

        Optional<Student> maybeStudent = service.findByStudentNo(new Long(number)); //Long형이 아니면 안들어간다.
        Student student = maybeStudent.get(); //값이 조건에 맞는 리스트를 다 넣기때문에 ()안에 숫자가 없다.

        log.info("Number Info: " + student);
        log.info("The grade of this student is: " + student.getGradeList().get(0).getGrade());

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserInfo> jpaLogin(@RequestBody StudentRequest studentRequest, HttpServletRequest request) throws Exception {
        log.info("jpaLogin(): " + studentRequest.getStudentId() + ", " + studentRequest.getStudentPw() + ", " + studentRequest.getStudentGrade());

        Boolean isSuccess = service.login(studentRequest);

        if(isSuccess) {
            log.info("Login Success");

            info = new UserInfo();
            info.setStudentId(studentRequest.getStudentId());
            log.info("Session Info: " + info);

            session = request.getSession(); //세션 타이머 시작 부분?
            session.setAttribute("student", info); //student라는 객체에 info를 넣는다?
        } else {
            log.info("Login Failure");
            info =  null;
        }
        return new ResponseEntity<UserInfo>(info, HttpStatus.OK);
    }

    @PostMapping("/needSession")
    public ResponseEntity<Boolean> postNeedSession(HttpServletRequest request) throws Exception{
        Object obj = session.getAttribute("student"); //30초가 지나면 이 student도 소멸

        Boolean isLogin = false;

        if(obj != null) {
            log.info("Session Info: " + info);

            isLogin = service.checkStudentIdValidation(info.getStudentId());

            log.info("isLogin:" + isLogin);
            return new ResponseEntity<Boolean>(isLogin, HttpStatus.OK);
        }
        log.info("isLogin:" + isLogin);
        return new ResponseEntity<Boolean>(isLogin, HttpStatus.OK);
        //이부분은 세션이 만료되면 invalidate: Session already invalidated가되서 의미없는것같은데.. 애초에 isLogin = false가 반환이 안된다.
    }

    @PostMapping("/removeSession")
    public ResponseEntity<Boolean> removeSession(HttpServletRequest request) throws Exception {
        Boolean mustFalse = false;

        session.invalidate();

        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
        //이부분은 세션이 만료되면 invalidate: Session already invalidated가되서 의미없는것같은데.. 애초에 isLogin = false가 반환이 안된다.
        //이부분도 마찬가지
    }
}
