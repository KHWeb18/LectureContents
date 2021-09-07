package com.example.demo.controller.member;

import com.example.demo.controller.concert.request.ConcertDeleteRequest;
import com.example.demo.controller.concert.request.ConcertRequest;
import com.example.demo.controller.member.request.LikedOrNotRequest;
import com.example.demo.controller.member.request.MemberRequest;
import com.example.demo.controller.member.request.TasteRequest;
import com.example.demo.controller.member.response.MemberResponse;
import com.example.demo.controller.session.MemberInfo;
import com.example.demo.entity.member.Member;
import com.example.demo.repository.member.MemberIdentityRepository;
import com.example.demo.service.member.MemberService;
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

@Slf4j
@Controller
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    @Autowired
    private MemberIdentityRepository memberIdentityRepository;

    private MemberInfo info;

    private HttpSession session;

    @PostMapping("/signup")
    public ResponseEntity<Boolean> singup(@Validated @RequestBody MemberRequest memberRequest) throws Exception {
        log.info("memberRequest(): " + memberRequest);

        boolean NotIdThatExists = service.register(memberRequest);

        return new ResponseEntity<Boolean>(NotIdThatExists, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberResponse> login(@Validated @RequestBody MemberRequest memberRequest, HttpServletRequest request) throws Exception {
        log.info("login(): " + memberRequest.getId() + ", " + memberRequest.getPassword());

        log.info("confirmedMember: " + service.login(memberRequest));

        if(service.login(memberRequest).getId().length() > 2) {
            log.info("login Success");

            info = new MemberInfo();
            info.setMemberId(memberRequest.getId());
            log.info("Session Info: " + info);

            session = request.getSession();
            session.setAttribute("member", info);

            Member member = service.login(memberRequest);

            MemberResponse memberResponse = new MemberResponse(member.getMemberNo(), member.getId(),
                    memberIdentityRepository.findIdentityByMemberNo(new Long(member.getMemberNo())).get().getIdentity());
                    // * memberNo, id, identity 3가지만 login에 대한 응답으로 보내줌 *

            log.info("response: " + memberResponse.getMemberNo(), memberResponse.getId(), memberResponse.getIdentity());
            return new ResponseEntity<MemberResponse>(memberResponse, HttpStatus.OK);

        } else {
            log.info("Login Failure");

            MemberResponse memberResponse = new MemberResponse(new Long(0), "no", "no");
            return new ResponseEntity<MemberResponse>(memberResponse, HttpStatus.OK);
        }
    }

    @PostMapping("/needSession")
    public ResponseEntity<Boolean> needSession(HttpServletRequest request) throws Exception {

        Boolean isLoggedIn = false;

        try {
          //Object obj = session.getAttribute("member");
          isLoggedIn = service.checkSessionValidation(info.getMemberId());

          log.info("Session Validation: " + isLoggedIn);
          return new ResponseEntity<Boolean>(isLoggedIn, HttpStatus.OK);

        } catch (NullPointerException nullPointerException) {

            log.info("Session Validation: " + isLoggedIn);
            return new ResponseEntity<Boolean>(isLoggedIn, HttpStatus.OK);

        } catch (IllegalStateException illegalStateException) {

            log.info("Session Validation: " + isLoggedIn);
            return new ResponseEntity<Boolean>(isLoggedIn, HttpStatus.OK);

        } finally {
            ;
        }

    }

    @GetMapping("/list")
    public ResponseEntity<List<Member>> list() throws Exception {
        log.info("getList(): " + service.getList());

        List<Member> list = service.getList();

        return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
    }

    @GetMapping("/read/{memberNo}")
    public ResponseEntity<Member> read(@PathVariable("memberNo") Integer memberNo) throws Exception {
        log.info("getRead(): " + service.read(new Long(memberNo)));

        return new ResponseEntity<Member>(service.read(new Long(memberNo)), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{memberNo}")
    public ResponseEntity<Void> delete(@PathVariable("memberNo") Integer memberNo) throws Exception {
        log.info("delete(): memberNo " + memberNo);

        service.delete(new Long(memberNo));

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<MemberResponse> modify(@Validated @RequestBody MemberRequest memberRequest) throws Exception {
        log.info("modify(): " + memberRequest);

        MemberResponse memberResponse = service.modify(memberRequest);

        return new ResponseEntity<MemberResponse>(memberResponse, HttpStatus.OK);
    }

    @PostMapping("/addLiked")
    public ResponseEntity<Void> addLiked(@Validated @RequestBody ConcertRequest concertRequest) throws Exception {
        log.info("addLiked(): concertRequest - " + concertRequest);

        service.addLiked(concertRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/deleteLiked")
    public ResponseEntity<Void> deleteLiked(@Validated @RequestBody ConcertDeleteRequest concertDeleteRequest) throws Exception {

        log.info("deleteLiked(): concertNo - " + concertDeleteRequest.getConcertNo() + ", memberNo - " + concertDeleteRequest.getMemberNo());

        service.deleteLiked(concertDeleteRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/fetchLikedOrNot") //ConcertDetailPage로 들어갈 때 이 공연이 이미 찜된건지 아닌건지를 판별해서 true또는 false를 반환, 그리고 화면에서 찜하기버튼이 나올지 취소버튼이 나올지를 결정
    public ResponseEntity<Boolean> fetchLikedOrNot(@Validated @RequestBody LikedOrNotRequest likedOrNotRequest) throws Exception {

        log.info("likedOrNotCheckNums: " + likedOrNotRequest);

        boolean isAlreadyLiked = false;

        try {
            Long memberNo = new Long(likedOrNotRequest.getLikedOrNotCheckNums()[0]);
            Long concertNo = new Long(likedOrNotRequest.getLikedOrNotCheckNums()[1]);

            isAlreadyLiked = service.isNotAlreadyLiked(memberNo, concertNo);

        } catch (NullPointerException nullPointerException) {

            log.info("Not LoggedIn");
            return new ResponseEntity<Boolean>(!isAlreadyLiked, HttpStatus.OK);

        } finally {
            ;
        }

        return new ResponseEntity<Boolean>(isAlreadyLiked, HttpStatus.OK);
    }

    @PostMapping("/checkPassword")
    public ResponseEntity<Boolean> checkPassword(@Validated @RequestBody MemberRequest memberRequest) throws Exception {
        log.info("checkPassword: " + memberRequest);

        boolean isRightPassword = false;

        isRightPassword = service.checkPassword(memberRequest);

        return new ResponseEntity<Boolean>(isRightPassword, HttpStatus.OK);
    }
}
