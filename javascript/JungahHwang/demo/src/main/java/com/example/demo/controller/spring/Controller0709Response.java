package com.example.demo.controller.spring;

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
// RestController: 전송한 객체를 json형태로 반환
// postMapping을 하지 않아도 post처럼 동작(post는 json을 반환함)
public class Controller0709Response {

    @GetMapping("/jsonMember")
    public Member jsonMember () {
        log.info("jsonMember()");

        Member member = new Member();
        member.setId("name");
        member.setPw("test");

        return member;
        // {
        //  "id": "name",
        //  "pw": "test"
        // }
    }

    @GetMapping("/jsonListMember")
    public List<Member> jsonListMember () {
        log.info("jsonListMember()");

        List<Member> list = new ArrayList<Member>();

        Member member1 = new Member();
        member1.setId("name1");
        member1.setPw("test1");
        list.add(member1);

        Member member2 = new Member();
        member2.setId("name2");
        member2.setPw("test2");
        list.add(member2);

        return list;

        // [
        //   {
        //      "id": "name1",
        //      "pw": "test1"
        //   },
        //   {
        //      "id": "name2",
        //      "pw": "test2"
        //   }
        // ]
    }
    @GetMapping("/jsonHashMapMember")
    public Map<String, Member> jsonHashMapMember () {
        log.info("jsonHashMapMember()");

        Map<String, Member> map = new HashMap<String, Member>();

        Member member1 = new Member();
        member1.setId("name1");
        member1.setPw("test1");
        map.put("key1", member1);

        Member member2 = new Member();
        member2.setId("name2");
        member2.setPw("test2");
        map.put("key2", member2);

        return map;

        // {
        //   "key1": {
        //   "id": "name1",
        //   "pw": "test1"
        //   },
        //   "key2": {
        //   "id": "name2",
        //   "pw": "test2"
        //   }
        // }
    }
    @GetMapping("/jsonVoid")
    // ResponseEntity<Void>: 전달할 데이터는 없고 전달완료만 알리고 싶을 때
    public ResponseEntity<Void> jsonVoid () {
        log.info("jsonVoid()");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/jsonString")
    // ResponseEntity<String>: 데이터를 string으로 받고 싶을 때
    // <>안에 전달하고자 하는 데이터 타입을 입력하면 됨 ex) Boolean ...
    public ResponseEntity<String> jsonString () {
        log.info("jsonString()");

        return new ResponseEntity<String>("Success",HttpStatus.OK);
    }
}

















