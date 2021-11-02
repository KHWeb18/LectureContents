package com.example.demo.controller.springtest;

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

@Slf4j
@Controller
@RequestMapping("/board")
// 가변인자 설정하기
public class PathVariableController {

    @Autowired
    private BoardService service;

    @GetMapping("/modify")
    public String getBoardModify (int boardNo, Model model) throws Exception {
        log.info("getBoardModify()");

        model.addAttribute(service.read(boardNo));

        return "/board/eighth/modify";
    }

    @PostMapping("/modify")
    public String postBoardModify (Board board, Model model) throws Exception {
        log.info("postBoardModify(): " + board);

        service.modify(board);
        model.addAttribute("msg", "수정이 성공적으로 완료되었습니다!");

        return "/board/fourth/success";
    }

    @GetMapping("/lists")
    public String getBoardLists (Model model) throws Exception {
        log.info("getBoardList(): " + service.list());

        model.addAttribute("lists", service.list());

        return "/board/fifth/lists";
    }

    @GetMapping("/register")
    public String getBoardRegister (Board board, Model model) {
        log.info("getBoardRegister()");
        return "/board/fourth/register";
    }

    @PostMapping("/register")
    public String postBoardRegister (Board board, Model model) throws Exception {
        log.info("postBoardRegister()");
        log.info("Board: " + board);

        service.register(board);

        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/board/fourth/success";
    }

    // 가변 인자 설정
    // baardNo : 게시물 번호
    // <boardNo} + @PathVariable("boardNo") int boardNo를 통해
    // boardNo으로 들어온 URL에 해당하는 숫자를 boardNo 입력 인자에 저장함
    @GetMapping("/read/{boardNo}")
    public String getBoardRead (@PathVariable("boardNo") int boardNo, Model model) throws Exception {
        log.info("getBoardRead(): " + boardNo);

        model.addAttribute(service.read(boardNo));

        return "board/seventh/read";
    }

    @PostMapping("/remove")
    public String postBoardRemove (int boardNo, Model model) throws Exception {
        log.info("postBoardRemove");

        service.remove(boardNo);

        model.addAttribute("msg", "삭제가 완료되었습니다!");

        return "board/fourth/success";
    }
}