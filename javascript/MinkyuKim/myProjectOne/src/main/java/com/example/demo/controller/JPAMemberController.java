package com.example.demo.controller;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.controller.session.UserInfo;
import com.example.demo.entity.Member;
import com.example.demo.service.JPAMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/member")
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
                (memberRequest.getAuth().equals("판매회원") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        log.info("name() -" + memberRequest.getName());

        service.register(memberRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
/*
    @PostMapping("/login")
    public ResponseEntity<UserInfo> jpaLogin(
            @RequestBody MemberRequest memberRequest,
            HttpServletRequest request
    ) throws Exception {

        // id pw가 null값인것은 RequestBody가 받지 못한다는 의미
        log.info("jpaLogin() - userId: " + memberRequest.getUserId() + ", password: " + memberRequest.getPassword());

        // 1) jpa에서 넘어가고
        Boolean isSuccess = service.login(memberRequest);

        // 2) 로그인 성공을 할시 세션처리하겠다
        if (isSuccess) {
            log.info("Login Success");
            // 3) 세션 할당
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
        //세션이 없는것으로 false를 리턴한다
        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<Void> jpaJPQLTest(
            @RequestBody MemberRequest memberRequest) throws Exception {

        log.info("jpaJPQLTest()");

        Optional<Member> maybeMember = service.findByAuth(new Long(3));
        // get은 정보가져오기. 가져올 데이터가 없으면 그냥 둠
        Member member = maybeMember.get();

        // 사업자로 넘어오면 ROLE_BUSINESS로 아니면 ROLE_CUSTOMER로 보이게
        log.info("Auth: " + (member.getAuthList().get(0).getAuth().equals("사업자") ?
                "ROLE_BUSINESS" : "ROLE_CUSTOMER"));

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

 */

}