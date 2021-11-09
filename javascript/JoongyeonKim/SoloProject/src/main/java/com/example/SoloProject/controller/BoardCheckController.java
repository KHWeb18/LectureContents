package com.example.SoloProject.controller;

import com.example.SoloProject.entity.Board;
import com.example.SoloProject.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardCheckController {

    @Autowired
    private BoardService boardservice;


    @GetMapping("/register")
    public String getRegister (Board board, Model model) {
        log.info("getRegister()");

        return "/board/register";
    }

    @PostMapping("/register")
    public String postRegister (Board board, Model model) throws Exception {
        log.info("postRegister()");
        log.info("Board: " + board);

        boardservice.register(board);

        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/board/success";  //이 postMapping은 유저가 게시글을 올리면 등록이 완료되었다는 메시지를 출력해야하기 때문에 success로 간다
    }

    @GetMapping("/read")
    public String getRead (int boardNo, Model model) throws Exception{
        log.info("read");

        model.addAttribute(boardservice.read(boardNo));

        return "/board/read";
    }

    @PostMapping("/remove")
    public String remove (int boardNo, Model model) throws Exception{
        log.info("remove");

        boardservice.remove(boardNo);

        model.addAttribute("msg", "삭제가 완료되었습니다");

        return "/board/success";
    }

    @Autowired
    private BoardService listservice;

    @GetMapping("/lists")
    public String getLists (Model model) throws Exception {
        log.info("getLists(): " + listservice.list());

        model.addAttribute("lists", listservice.list());

        return "/board/lists";
    }

    @GetMapping("/modify")
    public String getModify(int boardNo, Model model) throws Exception{
        log.info("getmodify()");

        model.addAttribute(boardservice.read(boardNo));

        return "/board/modify";
    }

    @PostMapping("/modify")
    public String postModify (Board board, Model model) throws Exception{
        log.info("postModify()");

        boardservice.modify(board);
        model.addAttribute("msg", "수정이 성공적으로 완료되었습니다");

        return  "/board/success";
    }

    @GetMapping("/search")
    public String getSearch(int boardNo, Model model) throws Exception{
        log.info("getSearch()");

        model.addAttribute(boardservice.read(boardNo));

        return "/board/modify";
    }

    @PostMapping("/search")
    public String postSearch (Board board, Model model) throws Exception{
        log.info("postSearch()");

        boardservice.modify(board);
        model.addAttribute("msg", "수정이 성공적으로 완료되었습니다");

        return  "/board/success";
    }
}
