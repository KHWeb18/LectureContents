package com.example.jswithspring.controller.vue.jpa;

import com.example.jswithspring.controller.vue.jpa.request.SignInForm;
import com.example.jswithspring.controller.vue.jpa.response.ResponseSession;
import com.example.jswithspring.service.jpa.AccountService;
import com.example.jswithspring.service.jpa.SignInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/jpasession")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPAMemberLoginSessionController {

    @Autowired
    private SignInService signInService;

    @Autowired
    private AccountService service;

    @PostMapping("sign-in")
    public ResponseEntity<ResponseSession> signIn(@RequestBody SignInForm form) {

        log.info("signIn(): " + form.getEmail() + ", " + form.getPassword());

        Boolean isLogin = signInService.signIn(form);

        log.info("Test Success!!!");

        String hashcode;

        if (isLogin) {
            hashcode = form.getEmail() + form.getEmail().hashCode();
        } else {
            hashcode = null;
        }

        ResponseSession rs = new ResponseSession(form.getEmail(), hashcode);

        return new ResponseEntity<ResponseSession>(rs, HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<Void> getRegister(@RequestBody SignInForm form) throws Exception {

        log.info("jpaRegister(): " + form.getEmail() + ", " + form.getPassword());

        service.register(form);

        log.info("Register Success!!!");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
