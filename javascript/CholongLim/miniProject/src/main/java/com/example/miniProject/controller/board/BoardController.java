//package com.example.miniProject.controller.board;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Slf4j
//@Controller
//public class BoardController {
//
//    @Autowired
//    private BoardService service;
//
//    @GetMapping("/register")
//    public String getRegister (Board board, Model model) {
//        log.info("getRegister()");
//
//        return "/board/register";
//    }
//
//    @PostMapping("/register")
//    public String postRegister (Board board, Model model) throws Exception {
//        log.info("postRegister()");
//        log.info("Board: " + board);
//
//        service.register(board);
//        model.addAttribute("msg", "게시물 등록이 완료되었습니다.");
//
//        return "/board/success";
//    }
//
//    // 게시판 목록
//    @GetMapping("/lists")
//    public String getLists (Model model) throws Exception {
//        log.info("getLists()");
//
//        model.addAttribute("lists",service.list());
//
//        return "/board/lists";
//
//    }
//
//    @GetMapping("/read")
//    public String getRead(int boardNo, Model model) throws Exception {
//        log.info("read");
//
//        model.addAttribute(service.read(boardNo));
//
//        return "/board/read";
//    }
//
//    @PostMapping("/remove")
//    public String remove (int boardNo, Model model) throws Exception {
//        log.info("remove");
//
//        service.remove(boardNo);
//        model.addAttribute("msg", "게시물 삭제가 완료되었습니다.");
//
//        return "/board/success";
//
//    }
//
//    @GetMapping("/modify")
//    public String getModify (int boardNo, Model model) throws Exception {
//        log.info("getModify()");
//
//        model.addAttribute(service.read(boardNo));
//
//        return "/board/modify";
//    }
//
//    @PostMapping("/modify")
//    public String postModify (Board board, Model model) throws Exception {
//        log.info("postModify(): " + board);
//
//        service.modify(board);
//        model.addAttribute("msg", "수정이 성공적으로 완료되었습니다!");
//
//        return "/board/success";
//    }
//}
