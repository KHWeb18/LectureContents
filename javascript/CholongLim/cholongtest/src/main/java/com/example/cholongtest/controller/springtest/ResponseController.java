package com.example.cholongtest.controller.springtest;

import com.example.cholongtest.entity.Membership;
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
//데이터를 json 으로 파싱한다 = post 처럼 동작시킨다
public class ResponseController {

    @GetMapping("/jsonMember")
    public Membership jsonMember() {
        log.info("jsonMember()");

        Membership membership = new Membership();
        membership.setMemID("name");
        membership.setMemPassword("test");

        return membership;
    }

    @GetMapping("/jsonListMember")
    public List<Membership> jsonListMember() {
        log.info("jsonListMember()");

        List<Membership> list = new ArrayList<Membership>();

        Membership membership1 = new Membership();
        membership1.setMemID("name1");
        membership1.setMemPassword("test1");
        list.add(membership1);

        Membership membership2 = new Membership();
        membership2.setMemID("name2");
        membership2.setMemPassword("test2");
        list.add(membership2);

        return list;
    }

    @GetMapping("/jsonHashMapMember")
    public Map<String, Membership> jsonHashMapMember() {
        log.info("jsonHashMapMember()");

        Map<String, Membership> map = new HashMap<String, Membership>();

        Membership membership1 = new Membership();
        membership1.setMemID("name1");
        membership1.setMemPassword("test1");
        map.put("key1",membership1);

        Membership membership2 = new Membership();
        membership2.setMemID("name2");
        membership2.setMemPassword("test2");
        map.put("key2",membership2);

        return map;
    }

    @GetMapping("/jsonVoid")
    public ResponseEntity<Void> jsonVoid() {
        log.info("jsonVoid()");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/jsonString")
    public ResponseEntity<String> jsonString() {
        log.info("jsonString()");

        return new ResponseEntity<String>("Success",HttpStatus.OK);
    }
}
