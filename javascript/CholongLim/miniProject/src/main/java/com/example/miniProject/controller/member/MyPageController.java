//package com.example.miniProject.controller.member;
//
//import com.example.miniProject.controller.session.UserInfo;
//import com.example.miniProject.entity.jpa.Member;
//import com.example.miniProject.service.jpa.JPAMemberService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Slf4j
//@Controller
//@RequestMapping("/jpamember")
//@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
//public class MyPageController {
//    private UserInfo info;
//
//    private Member memberId;
//
//    @Autowired
//    private JPAMemberService userService;
//
//    @GetMapping("/lists")
//    public ResponseEntity<List<Member>> getLists () throws Exception {
//        log.info("getLists(): " + userService.list());
//
//        return new ResponseEntity<>(userService.list(), HttpStatus.OK);
//    }
//}
