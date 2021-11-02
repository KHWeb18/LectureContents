package com.example.jswithspring.controller.springtest;


import com.example.jswithspring.entity.Board;
import com.example.jswithspring.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Slf4j
@Controller
@RequestMapping("/board")
public class PathVariableController {

    @Autowired
    private BoardService service;

    @GetMapping("/modify")
    public String getBoardModify (int boardNo, Model model) throws Exception {
        log.info("getModify()");

        model.addAttribute(service.read(boardNo));

        return "/board/eighth/modify";
    }

    @PostMapping("/modify")
    public String postBoardModify (Board board, Model model) throws Exception {
        log.info("postModify(): " + board);

        service.modify(board);
        model.addAttribute("msg", "수정이 성공적으로 완료되었습니다!");

        return "/board/fourth/success";
    }

    @GetMapping("/lists")
    public String getBoardLists (Model model) throws Exception {
        log.info("getLists(): " + service.list());

        model.addAttribute("lists", service.list());

        return "/board/fifth/lists";
    }


    @GetMapping("/register")
    public String getBoardRegister (Board board, Model model) {
        log.info("getRegister()");

        return "/board/fourth/register";
    }

    @PostMapping("/register")
    public String postBoardRegister (Board board, Model model) throws Exception {
        log.info("postRegister()");
        log.info("Board: " + board);

        service.register(board);


        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/board/fourth/success";
    }

 /*   @GetMapping("/read")
    public String getBoardRead (int boardNo, Model model) throws Exception {
        log.info("getBoardRead");


        model.addAttribute(service.read(boardNo));

        return "board/seventh/read";
    }*/

    @PostMapping("/remove")
    public String getBoardremove (int boardNo, Model model) throws Exception {
        log.info("getBoardremove");

        service.remove(boardNo);

        model.addAttribute("msg", "삭제가 완료되었습니다!");

        return "board/fourth/success";
    }


    // boardNo: 얘는 어떤의미지?
    //      게시물번호 <<고정인가요?
    //      몇번인지 알수없음 << 사용자가 몇번 누를지 아무도 모름
    //      {boardNo} + @PathVariable("boardNo) int boardNo를 통해
    //      boardNo로 들어온 url에 해당하는 숫자를 boardNo입력 인자에 저장함
    @GetMapping("/read/{boardNo}")
    public String getBoardRead (@PathVariable("boardNo") int boardNo, Model model) throws Exception {
        log.info("getBoardRead(): " + boardNo);

        model.addAttribute(service.read(boardNo));
        return "board/seventh/read";
    }
}
