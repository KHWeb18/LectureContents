package com.example.demo.springTest;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/http-method")
public class HttpMethodController {

    @Autowired
    private BoardService service;

    /*
    boardNo는 무슨의미일까?
    개시물번호 가 고정이 아니기떄문에
    몇번 누를지 알수가없을 사용자도 아직모름
    {boardNo}+@PathVariable("boardNo") int boardNo를 통해
     boardNo로 들어온 URL에 해당하는 숫자를 boardNo 입력 인자에 저장함.
    */

    @GetMapping("/read/{boardNo}")
    public String getRead (@PathVariable("boardNo") int boardNo )  {
        log.info("getBoardRead():" +boardNo);



        return "httpmethod/read";
    }

    @PostMapping("/remove")
    public  String PostMethodremove() {
        log.info("PostMethodremove()");

        return "/httpmethod/remove";
    }
    @GetMapping("PercentTest")
    public String getPercentTest(){
        log.info("gerPercentTest()");

        return "/csstest/nineth/percentTest";
    }

    @GetMapping("getTransparencyTest")
    public  String getTransparencyTest(){
        log.info("getTransparencyTest");

        return "/csstest/nineth/transparencyTest";
    }

    @GetMapping("/getBackgroundClipTest")
    public  String getBackgroundClipTest(){
        log.info("getBackgroundClipTest");

        return "/csstest/nineth/BackgroundClipTest";
    }
    @GetMapping("/getGradientTest")
    public String getGradientTest(){
        log.info("getGradientTest()");

        return "/csstest/nineth/GradientTest";
    }

    @GetMapping("/customBoxTest")
    public String getcustomBoxtTest(){
        log.info("getcustomBoxtTest()");

        return "/csstest/nineth/customBoxTest";
    }

    @GetMapping("/getInlineBlockTest")
    public  String getInlineBolockTest(){
        log.info("getInlineBlockTest()");

        return "/csstest/nineth/inlineblockTest";
    }
    @GetMapping("/getNavigationbarTest")
    public  String getNavigationbarTest(){
        log.info("getNavigationbarTest()");

        return "/csstest/nineth/getNavigationbarTest";
    }

    @GetMapping("/getparentChildTest")
    public String getparentChildTest(){
        log.info("getparentChildTest()");

        return "/csstest/nineth/parentChildTest";
    }

    @GetMapping("/getBackgroundUrlTest")
    public String getBackgroundTest(){
        log.info("getBackgroundUrlTest()");

        return "/csstest/nineth/BackgroundUrlTest";
    }
    // 스프링이 자동으로 객체를 찾을 수 있게 서포트함


    @GetMapping("/register")
    public String getMethodRegister () {
        log.info("getMethodRRegister()");

        return "/httpmethod/register";
    }

    @PostMapping("/register")
    public String postMethodRRegister () {

        log.info("postMethodRRegister()");

        return "/httpmethod/register";
    }

    @GetMapping("/lists")
    public String getMethodLists() {

        log.info("getMethodList()");


        return "/httpmethod/lists";
    }


    @GetMapping("/modify")
    public  String getMethodModify () throws  Exception{

        log.info("getMethodModify()");

        return "/httpmethod/modify";
    }

    @PostMapping("/modify")
    public  String postMethodModify() throws  Exception{
        log.info("postMethodModify()");


        return "/httpmethod/modify";
    }
}
