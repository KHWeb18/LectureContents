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
// 제이슨 형태로 객체데이터를 반환한다. 즉 post형태로 동작한다라는 의미
// @restcontroller를 사용하면 getMapping을 post처럼 반환할 수 있다
@RestController
public class ResponseController {

    @GetMapping("jsonMember")
    public Member jsonMember () {
        log.info("jsonMember()");

        Member member = new Member();
        member.setId("name");
        member.setPw("test");

        return member;
    }

    // List 방식으로 집어넣기
    @GetMapping("/jsonListMember")
    public List<Member> jsonListMember() {
        log.info("jsonListMember()");

        List<Member> list = new ArrayList<Member>();

        Member member1 = new Member();
        member1.setId("name1");
        member1.setPw("test1");
        list.add(member1);

        Member member2 = new Member();
        member2.setId("name1");
        member2.setPw("test1");
        list.add(member2);

        return list;
    }
    // HashMap방식으로 집어넣기
    @GetMapping("/jsonHashMapMember")
    public Map<String, Member> jsonHashMapMember() {
        log.info("jsonHashMapMember()");

        Map<String, Member> map = new HashMap<String, Member>();

        Member member1 = new Member();
        member1.setId("name1");
        member1.setPw("test1");
        map.put("key1", member1);

        Member member2 = new Member();
        member2.setId("name1");
        member2.setPw("test1");
        map.put("key2", member2);

        return map;
    }
    // json에서 void로 보내는 방식
    // ResponseEntity<Void>를 사용해야 한다.
    // 만약 참거짓을 판별하려면 Boolean을 사용해야 한다.(대문자 조심, 항상 전달은 객체를 던져야 한다)
    @GetMapping("/jsonVoid")
    public ResponseEntity<Void> jsonVoid() {
        log.info("jsonVoid()");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // json으로 메시지 전달하기
    // f12 network상에서 status가 200이 나와야 잘 전달된 것.
    @GetMapping("/jsonString")
    public ResponseEntity<String> jsonString () {
        log.info("jsonString()");

        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
}
