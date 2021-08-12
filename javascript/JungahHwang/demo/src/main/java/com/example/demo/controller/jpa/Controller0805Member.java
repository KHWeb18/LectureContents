package com.example.demo.controller.jpa;

import com.example.demo.controller.jpa.request.MemberRequest;
import com.example.demo.controller.session.UserInfo;
import com.example.demo.entity.jpa.Member;
import com.example.demo.service.jpa.MemberService;
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
@RequestMapping("/jpamember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Controller0805Member {

    @Autowired
    private MemberService service;

    private UserInfo info;

    private HttpSession session;

    @PostMapping("/register")
    public ResponseEntity<Void> jpaRegister(@Validated @RequestBody MemberRequest memberRequest) throws Exception {
        log.info("jpaRegister(id: " + memberRequest.getId() + ", pw: " + memberRequest.getPw() + ", " +
                (memberRequest.getAuth().equals("사업자") ? "ROLE_BUSINESS)" : "ROLE_INDIVIDUAL)"));

        service.register(memberRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/jpql")
    public ResponseEntity<Void> jpaJPQLTest (@RequestBody MemberRequest memberRequest) throws Exception {
        log.info("jpaJPQLTest");

        Optional<Member> maybeMember = service.findByAuth(new Long(1));
        Member member =  maybeMember.get();

        log.info("Auth: " + (member.getAuthList().get(0).getAuth()
                .equals("사업자") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserInfo> jpaLogin(
            @RequestBody MemberRequest memberRequest, HttpServletRequest request) throws Exception {
        log.info("jpaLogin");

        Boolean isSuccess = service.login(memberRequest);

        if (isSuccess) {
            log.info("Login Success");
            // 세션 할당
            info = new UserInfo();
            info.setId(memberRequest.getId());

            log.info("Session Info: " + info);

            session = request.getSession();
            session.setAttribute("member", info);
        } else {
            log.info("Login Failure");
            info = null;
        }

        return new ResponseEntity<UserInfo>(info, HttpStatus.OK);
    }

    @PostMapping("/needSession")
    public ResponseEntity<Boolean> needSession(HttpServletRequest request) throws Exception {
        Object obj = session.getAttribute("member");

        Boolean isLogin = false;

        if (obj != null) {
            log.info("Session Info: " + info);

            isLogin = service.checkUserIdValidation(info.getId());
        }

        return new ResponseEntity<Boolean>(isLogin, HttpStatus.OK);
    }

    // 로그아웃 -> 게시물 작성
    // Spring 자체에서 처리가 불가능하므로
    // 로그아웃시 Vue쪽에 세션이 없다는 정보를 전달해줘야한다.
    // 그리고 사용자가 게시물 작성을 누르면 이 정보(참, 거짓)을 보고
    // 강제로 로그인 페이지로 보내거나 참(세션이 있음)이면 그대로 처리하는 방식을 취하도록 만들면 됨

    @PostMapping("/removeSession")
    public ResponseEntity<Boolean> removeSession(HttpServletRequest request) throws Exception {
        Boolean mustFalse = false;

        session.invalidate();

        log.info("removeSession");

        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
    }
}

















