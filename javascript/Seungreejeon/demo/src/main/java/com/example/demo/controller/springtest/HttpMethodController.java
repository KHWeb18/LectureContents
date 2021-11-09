package com.example.demo.controller.springtest;



import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller

@RequestMapping(value = "/http-method")
public class HttpMethodController {


    @GetMapping("/modify")
    public String getBoardModify() throws Exception {
        log.info("getMethodModify()");

        return "/httpmethod/modify";
    }

    @PostMapping("modify")
    public String postBoardModify() {
        log.info("postMethodModify()");


        return "/httpmethod/modify";
    }


    @GetMapping("/lists")
    public String getBoardLists() throws Exception {
        log.info("getMethodlists()");

        return "/httpmethod/lists";
    }
    //boardNo: 은 게시물번호는 누가 몇번을 누를지 모르기때문에
    //         가변인자 처리가 필요하다.
    //         {boardNo} + @PathVariable("boardNo") int boardNo을 통해 boardNo로 들어온 URL에 해당하는 숫자를 boardNo 입력 인자에 저장
    //          board/read/1

    @GetMapping("/read/{boardNo}")
    public String getMethodRead(@PathVariable("boardNo") int boardNo) throws Exception {
        log.info("getBoardRead():" + boardNo);

        return "/httpmethod/read";
    }

    @PostMapping("/remove")
    public String getMethodRemove() throws Exception {
        log.info("BoardRemove()");


        return "/httpmethod/remove";
    }

    @GetMapping("/register")
    public String getMethodRegister() {
        log.info("getMethodRegister()");

        return "/httpmethod/register";
    }

    @PostMapping("/register")
    public String postMethodRegister() throws Exception {
        log.info("postMethodRegister()");

        return "/httpmethod/register";
    }

    @GetMapping("/jsonVoid")
    public ResponseEntity<Void> jsonVoid (){
        log.info("jsonVoid()");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/jsonString")
    public ResponseEntity<String> jsonString () {
        log.info("jsonString()");

        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
}

