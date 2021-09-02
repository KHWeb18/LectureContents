package com.example.demo.controller.member;

import com.example.demo.controller.member.request.TasteRequest;
import com.example.demo.service.member.TasteService;
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
@RequestMapping("/member/taste")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class TasteController {

    @Autowired
    TasteService tasteService;

    @PostMapping("/postTaste")
    public ResponseEntity<Void> postTaste(@Validated @RequestBody TasteRequest tasteRequest) throws Exception {
        log.info("postTaste(): " + tasteRequest);

        tasteService.addTaste(tasteRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
