package com.example.demo.controller.springtest;


import com.example.demo.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ResponseController {

    @GetMapping("/jsonMember")
    public Member jsonMember() {
        log.info("jsonMember()");

        Member member = new Member();

        member.setId("name");
        member.setId("test");

        return member;
    }

    @GetMapping("/jsonListMember")
    public List<Member> jsonListMember() {
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
    }

    @GetMapping("/jsonHashMapMember")
    public Map<String,Member> jasonHashMapMember() {
        log.info("jasonHashMapMember()");

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
    }
}
