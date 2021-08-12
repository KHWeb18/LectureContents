package com.example.demo.controller.vue.jpa;

import com.example.demo.controller.vue.jpa.request.MemberRequest;
import com.example.demo.controller.vue.session.UserInfo;
import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.MemberAuth;
import com.example.demo.service.jpa.JPAMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/jpamember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")

public class JPAMemberController {

    private UserInfo info;

    @Autowired
    private JPAMemberService service;

    private HttpSession session;

    @PostMapping("/register")
    public ResponseEntity<Void> jpaRegister(
            @Validated @RequestBody MemberRequest memberRequest) throws Exception {

        log.info("jpaRegister(): " + memberRequest.getUserId() + ", " + memberRequest.getPassword() + ", " +
                (memberRequest.getAuth().equals("사업자") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        service.register(memberRequest);

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
                log.info("Session Info: " + info);

                session = request.getSession();
                session.setAttribute("member", info);
            } else {
                log.info("Login Failure");
                info = null;
            }

            // return new ResponseEntity<Boolean>(isSuccess, HttpStatus.OK);
            return new ResponseEntity<UserInfo>(info, HttpStatus.OK);
        }

        /*
        세션(Session)이란 일정 시간동안 같은 사용자(정확하게 브라우저를 말한다)로 부터 들어오는
        일련의 요구를 하나의 상태로 보고 그 상태를 일정하게 유지시키는 기술이다.
        방문자의 요청에 따른 정보를 방문자 메모리에 저장하는 것이 아닌 웹 서버가 세션 아이디 파일을 만들어
        서비스가 돌아가고 있는 서버에 저장하는 것이다.
        서버에 저장되기 때문에 사용자 정보가 노출되지 않는다.
         */
        @PostMapping("/needSession")
        public ResponseEntity<Boolean> postNeedSession(HttpServletRequest request) throws Exception {

            //UserInfo info = (UserInfo) session.getAttribute("member");
            Object obj = session.getAttribute("member");

            Boolean isLogin = false;

            if (obj != null) {
                log.info("Session Info: " + info);

                isLogin = service.checkUserIdValidation(info.getUserId());

                return new ResponseEntity<Boolean>(isLogin, HttpStatus.OK);
            }

            return new ResponseEntity<Boolean>(isLogin, HttpStatus.OK);
        }

        // 로그인 -> 게시물 작성
        //       -> 게시물 수정
        //       -> 팔로우
        //       -> 댓글 달기
        //       -> 삭제

        // 로그아웃 -> 게시물 작성
        // Spring 자체에서 처리가 불가능하므로
        // 로그아웃시 Vue쪽에 세션이 없다는 정보를 전달해줘야한다.
        // 그리고 사용자가 게시물 작성을 누르면 이 정보(참, 거짓)을 보고
        // 강제로 로그인 페이지로 보내거나 참(세션이 있음)이면 그대로 처리하는 방식을 취하도록 만들면 됨
        @PostMapping("/removeSession")
        public ResponseEntity<Boolean> removeSession(HttpServletRequest request) throws Exception {
            Boolean mustFalse = false;

            session.invalidate();

            return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
        }

        @PostMapping("/test")
        public ResponseEntity<Void> jpaJPQLTest(
                @RequestBody MemberRequest memberRequest) throws Exception {

            log.info("jpaJPQLTest()");

            Optional<Member> maybeMember = service.findByAuth(new Long(3));
            Member member = maybeMember.get();

            log.info("Auth: " + (member.getAuthList().get(0).getAuth().equals("사업자") ?
                    "ROLE_BUSINESS" : "ROLE_CUSTOMER"));

            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }