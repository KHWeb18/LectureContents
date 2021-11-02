package com.example.demo.springTest;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
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
@RequestMapping("/board")
public class PathVariableController {

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
    public String getRead (@PathVariable("boardNo") int boardNo, Model model) throws Exception {
        log.info("getBoardRead():" +boardNo);

        model.addAttribute(service.read(boardNo));

        return "board/seventh/read";
    }

    @PostMapping("/remove")
    public  String remove(int boardNo, Model model) throws  Exception{
        log.info("remove()");
        service.remove(boardNo);
        model.addAttribute("msg","삭제가완료되었습니다.");

        return "/board/fourth/success";
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
    public String getRegister (Board board, Model model) {
        log.info("getRegister()");

        return "/board/fourth/register";
    }
    //MVC (Model view Controller) Pattern
    // Model:  다루는데이터
    // view : 눈에 보이는 화면
    // COntroller: URL 제어
    @PostMapping("/register")
    public String postRegister ( Board board, Model model, HttpServletRequest rq) throws Exception{

        log.info("postRegister()");

        log.info("Board:" +board);

        String NAME = rq.getParameter("title");
        String NAME2 = rq.getParameter("writer");
        String NAME3 = rq.getParameter("content");




        service.register(board);

        // msg 라는 속성값에 "등록이 완료되었습니다"를 맵핌함
        // key msg value "등록이 완료되었습니다"

        model.addAttribute("msg", NAME);
        model.addAttribute("msg1", NAME2);
        model.addAttribute("msg2", NAME3);

        System.out.println(NAME);
        return "/board/fourth/success";
    }

    @GetMapping("/lists")
    public String getLists (Model model) throws Exception {

        log.info("gerList()");

        model.addAttribute("lists",service.list());

        return "/board/fifth/lists";
    }


    @GetMapping("/modify")
    public  String getModify (int boardNo, Model model) throws  Exception{

        log.info("getModify()");
        model.addAttribute(service.read(boardNo));
        return "/board/eighth/modify";
    }

    @PostMapping("/modify")
    public  String postModify(Board board, Model model) throws  Exception{
        log.info("postModify()");

        model.addAttribute("msg","수정되었습니다.");
        service.modify(board);
        return "/board/fourth/success";
    }
}
