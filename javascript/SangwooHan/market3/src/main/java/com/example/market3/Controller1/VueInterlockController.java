package com.example.market3.Controller1;

import com.example.market3.Entity.Market;
import com.example.market3.Entity.Signup;
import com.example.market3.Service.VuemarketService;
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
@RequestMapping("/vueTest")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueInterlockController {

    @Autowired
    private VuemarketService service;

    @PostMapping("/register")
    public ResponseEntity<Market> register(@Validated @RequestBody Market market) throws Exception {
        log.info("post register request from vue");

        service.register(market);

        return new ResponseEntity<>(market, HttpStatus.OK);
    }
}
