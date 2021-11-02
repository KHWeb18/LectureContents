package com.example.jswithspring.controller.board;

import com.example.jswithspring.entity.Board;
import com.example.jswithspring.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class EighthController {

    @Autowired
    private BoardService service;

    @GetMapping("/modify")
    public String getModify (int boardNo, Model model) throws Exception {
        log.info("getModify()");

        // 수정을 눌렀을때 기존 정보를 가져와야함
        model.addAttribute(service.read(boardNo));

        return "/board/eighth/modify";
    }

    @PostMapping("/modify")
    public String postModify (Board board, Model model) throws Exception {
        log.info("postModify(): " + board);

        service.modify(board);
        model.addAttribute("msg", "수정이 성공적으로 완료되었습니다!");

        return "/board/fourth/success";
    }
}
