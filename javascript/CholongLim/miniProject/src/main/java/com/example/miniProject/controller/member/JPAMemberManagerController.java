package com.example.miniProject.controller.member;


import com.example.miniProject.controller.member.request.MemberRequest;
import com.example.miniProject.entity.jpa.Board;
import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.entity.jpa.MemberAuth;
import com.example.miniProject.repository.jpa.JPABoardRepository;
import com.example.miniProject.repository.jpa.JPAMemberAuthRepository;
import com.example.miniProject.repository.jpa.JPAMemberRepository;
import com.example.miniProject.service.jpa.JPABoardService;
import com.example.miniProject.service.jpa.JPAMemberManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/memberManage")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPAMemberManagerController {

    @Autowired
    private JPAMemberManagerService memberManagerService;

    @Autowired
    private JPAMemberAuthRepository memberAuthRepository;


    @GetMapping("/lists")
    public ResponseEntity<List<Member>> getLists () throws Exception {
        log.info("getLists(): " + memberManagerService.list());

        return new ResponseEntity<>(memberManagerService.list(), HttpStatus.OK);
    }

    @GetMapping("/authLists")
    public ResponseEntity<List<MemberAuth>> getAuthLists () throws Exception {
        log.info("getAuthLists(): " + memberManagerService.authList());

        return new ResponseEntity<>(memberManagerService.authList(), HttpStatus.OK);
    }

    @GetMapping("/manager/{memberNo}")
    public ResponseEntity<Member> read(@PathVariable("memberNo") Long memberNo) throws Exception {
        Member member = memberManagerService.read(memberNo);

        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }

    @PutMapping("/manager/{memberNo}")
    public ResponseEntity<MemberRequest> modify(@PathVariable("memberNo") Long memberNo,
                                        @Validated @RequestBody MemberRequest memberRequest ) throws Exception {


        Optional<MemberAuth> modifyAuth = memberAuthRepository.findById(memberNo);

        modifyAuth.ifPresent( changeAuth ->{
            changeAuth.setAuth(memberRequest.getAuth());
            memberRequest.setMemberNo(memberNo);
            memberAuthRepository.save(changeAuth);
        });

        return new ResponseEntity<>(memberRequest, HttpStatus.OK);
    }

    @DeleteMapping("/{memberNo}")
    public ResponseEntity<Void> remove(@PathVariable("memberNo") Long memberNo) throws Exception {
        memberManagerService.remove(memberNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}



