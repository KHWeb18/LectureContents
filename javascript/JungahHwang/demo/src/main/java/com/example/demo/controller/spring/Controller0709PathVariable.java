package com.example.demo.controller.spring;

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
public class Controller0709PathVariable {
    @Autowired
    private BoardService service;

    @GetMapping("/register")
    public String getBoardRegister (Board board, Model model) throws Exception{
        log.info("getBoardRegister()");

        return "board/Review0617/register";
    }

    @PostMapping("/register")
    public String postBoardRegister (Board board, Model model) throws Exception {
        log.info("postBoardRegister()");

        service.register(board);

        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "board/Review0617/success";
    }

    @GetMapping("/lists")
    public String getBoardLists (Model model) throws Exception {
        log.info("getBoardLists(): " + model);

        model.addAttribute("lists", service.list());

        return "board/Review0709/lists";
    }
    // 가변인자 세팅하기
    // boardNo: 게시물 번호  -> 사용자가 몇 번을 누를 지 모름
    // boardNo으로 들어온 URL에 해당하는 숫자를 boardNo 입력 인자에 저장
    @GetMapping("/read/{boardNo}") // /{boardNo}
                             // @PathVariable("boardNo")
    public String getBoardRead (@PathVariable("boardNo") int boardNo, Model model) throws Exception {
        log.info("getBoardRead(): " + boardNo);

        model.addAttribute(service.read(boardNo));

        return "board/Review0622/read";
    }
    @PostMapping("/remove")
    public String postBoardRemove (int boardNo, Model model) throws Exception{
        log.info("postBoardRemove()");

        service.remove(boardNo);

        model.addAttribute("msg", "삭제가 완료되었습니다.");

        return "board/Review0617/success";
    }
    @GetMapping("/modify")
    public String getBoardModify (int boardNo, Model model) throws Exception {
        log.info("getBoardModify()");

        model.addAttribute(service.read(boardNo));

        return "board/Review0623/modify";
    }
    @PostMapping("/modify")
    public String postBoardModify (Board board, Model model) throws Exception{
        log.info("postBoardModify");

        service.modify(board);

        model.addAttribute("msg", "수정이 완료되었습니다.");

        return "board/Review0617/success";
    }
}
