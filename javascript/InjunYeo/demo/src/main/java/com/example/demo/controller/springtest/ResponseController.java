package com.example.demo.controller.springtest;


import com.example.demo.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
//데이터를 제이슨으로 반환한다는 말은 포스트처럼 동작시키겠다 라는 말이다.
//
public class ResponseController {

    @GetMapping("/jsonMember")
    public Member jsonMember(){
        log.info("jsonMember()");

        Member member = new Member();
        member.setId("name");
        member.setPassword("test");

        return member;
    }

    @GetMapping("/jsonListMember")
    public List<Member> jsonListMember(){
        log.info("jsonListMember()");

        List<Member> list = new ArrayList<Member>();

        Member member1 = new Member();
        member1.setId("name1");
        member1.setPassword("test1");

        list.add(member1);

        Member member2 = new Member();
        member1.setId("name2");
        member1.setPassword("test2");

        list.add(member2);

        return list;

    }
    @GetMapping("/jsonHashMember")
    public Map<String,Member> jsonHashMember(){
        log.info("jsonHashMember()");

        Map<String,Member> map = new HashMap<String,Member>();

        Member member1 = new Member();
        member1.setId("name1");
        member1.setPassword("test1");

        map.put("key1",member1);

        Member member2 = new Member();
        member1.setId("name2");
        member1.setPassword("test2");

        map.put("key2",member2);

        return map;

    }

    @GetMapping("/jsonVoid")
    //void에 대한걸 만들어주기위해 ResponseEntity를 사용한다.
    public ResponseEntity<Void> jsonVoid(){

        log.info("jsonVoid()");

        return new ResponseEntity<Void>(HttpStatus.OK);

    }

    @GetMapping("/jsonString")
    public ResponseEntity<String> jsonString(){
        log.info("jsonString()");

        return new ResponseEntity<String>("success",HttpStatus.OK);
    }

}
