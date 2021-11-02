package com.example.demo.controller.vue;

import com.example.demo.entity.VueMember;
import com.example.demo.service.VueMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/vuemember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")

public class VueMemberController {

    @Autowired
    private VueMemberService service;

    @PostMapping("/signup")
    public ResponseEntity<VueMember> signup(@Validated @RequestBody VueMember member) throws Exception {
        //@RequestBody은 값을 JSON형태로 출력되게한다.

        log.info("post signup request from vue");

        service.register(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<VueMember>> getList() throws Exception {
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{memberNo}")
    public ResponseEntity<VueMember> read(@PathVariable("memberNo") Integer memberNo) throws Exception {
        VueMember member = service.read(memberNo);

        return new ResponseEntity<VueMember>(member, HttpStatus.OK);
    }

    @PutMapping("/{memberNo}")
    //PutMapping???  클라이언트에서 axios.put으로 쐈으니 PutMapping으로 받아야한다!
    public ResponseEntity<VueMember> modify(@PathVariable("memberNo") Integer memberNo, @Validated @RequestBody VueMember member) throws Exception {
        //@Validated @RequestBody Board board --> !클라이언트에서 전송된 title, content를 JSON의 형태인 board로 인자로 받겠다는 뜻이다!

        member.setMemberNo(memberNo);
        service.modify(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @DeleteMapping("/{memberNo}")
    public ResponseEntity<Void> remove(@PathVariable("memberNo") Integer memberNo) throws Exception {
        service.remove(memberNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
