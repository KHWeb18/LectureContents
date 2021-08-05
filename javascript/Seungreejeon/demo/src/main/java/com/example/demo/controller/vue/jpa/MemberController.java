package com.example.demo.controller.vue.jpa;



import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.request.MemberRequest;
import com.example.demo.service.jpa.JPAMemberService;
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

@Slf4j
@Controller
@RequestMapping("/jpamember")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private JPAMemberService service;

    @PostMapping("/register")
    public ResponseEntity<Void> Vueregister(@Validated @RequestBody MemberRequest memberRequest) throws Exception {
        log.info("jpaRegister() UserId: : " + memberRequest.getUserId() + " " +
                "memberRequest.getpassword : " + memberRequest.getPassword() + " " +
                (memberRequest.getAuth().equals("사업자") ? "ROLES_BUSINESS" : "ROLES_INDIVIDUAL"));

        service.register(memberRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
