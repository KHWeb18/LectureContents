package com.example.miniProject.controller.member;

import com.example.miniProject.controller.member.request.MemberRequest;
import com.example.miniProject.controller.session.UserInfo;
import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.service.jpa.JPAMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpHeaders;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/jpamember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPAMemberController {

    private UserInfo info;

    private Member memberId;

    @Autowired
    private JPAMemberService service;

    private HttpSession session;

    @PostMapping("/register")
    public ResponseEntity<Void> jpaRegister(
            @Validated @RequestBody MemberRequest memberRequest,
            HttpServletRequest request) throws Exception {
        log.info("jpaRegister(): " + memberRequest.getUserId() + ", " + memberRequest.getPassword() + ", " +
                (memberRequest.getAuth().equals("개인") ? "ROLE_INDIVIDUAL" : "ROLE_MANAGER"));

        log.info("jpaRegister(): " + memberRequest.getUserId() + ", " + memberRequest.getPassword()  + ", " + memberRequest.getPasswordReInput());

            boolean ableId = service.duplicateCheck(memberRequest);

            if (memberRequest.getPassword().equals(memberRequest.getPasswordReInput())) {
                if(ableId){
                    log.info("able id");
                    log.info("register Success");
                    service.register(memberRequest);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                } else {
                    log.info("unable id");
                    this.info = null;
                }
            } else {
                log.info("register Fail");
                this.info = null;
            }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserInfo> jpaLogin(
            @RequestBody MemberRequest memberRequest,
            HttpServletRequest request
    ) throws Exception {

        log.info("jpaLogin() - userId: " + memberRequest.getUserId() + ", password: " + memberRequest.getPassword());

        Boolean isSuccess = service.login(memberRequest);

        if (isSuccess) {
            log.info("Login Success");
            // 세션 할당
            info = new UserInfo();
            info.setUserId(memberRequest.getUserId());
            info.setUserName(memberRequest.getUserName());
            info.setAuth(memberRequest.getAuth());
            info.setUserPhone(memberRequest.getUserPhone());

            log.info("Session Info: " + info);

            session = request.getSession();
            session.setAttribute("member", info);
        } else {
            log.info("Login Fail");
            info = null;
        }

        // return new ResponseEntity<Boolean>(isSuccess, HttpStatus.OK);
        return new ResponseEntity<UserInfo>(info, HttpStatus.OK);
    }

    // 로그인 세션
    @PostMapping("/needSession")
    public ResponseEntity<UserInfo> postNeedSession(HttpServletRequest request) throws Exception {

        //UserInfo info = (UserInfo) session.getAttribute("member");
        Object obj = session.getAttribute("member");

        Boolean isLogin = false;

        if (obj != null) {
            log.info("Session Info: " + info);

            isLogin = service.checkUserIdValidation(info.getUserId());
            return new ResponseEntity<UserInfo>(info,HttpStatus.OK);
        }

        return new ResponseEntity<UserInfo>(info, HttpStatus.OK);
    }

    // 세션 로그아웃
    @PostMapping("/removeSession")
    public ResponseEntity<Boolean> removeSession(HttpServletRequest request) throws Exception {
        Boolean mustFalse = false;

        session.invalidate();

        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
    }

}