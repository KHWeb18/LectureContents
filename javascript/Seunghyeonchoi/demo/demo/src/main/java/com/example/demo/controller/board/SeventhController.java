//package com.example.demo.controller.board;
//
//import com.example.demo.entity.Board;
//import com.example.demo.service.BoardService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Slf4j
//@Controller
//public class SeventhController {
//
//    @Autowired
//    private BoardService service;
//
//    @GetMapping("/read")
//    public String getRead (int boardNo, Model model) throws Exception {
//        log.info("read");
//
//        model.addAttribute(service.read(boardNo));
//
//        return "board/seventh/read";
//    }
//
//    // 글을 지워도 boardNo가 올라가야만 하는 이유가 무엇인가?
//    // 배열 100개에서 중간의 값을 지우는 경우
//    //
//    @PostMapping("/remove")
//    public String remove (int boardNo, Model model) throws Exception {
//        log.info("remove");
//
//        service.remove(boardNo);
//
//        model.addAttribute("msg", "삭제가 완료되었습니다!");
//
//        return "board/fourth/success";
//    }
//
//    @GetMapping("/{boardNo}")
//    public ResponseEntity<Board> read(@PathVariable("boardNo") Integer boardNo) throws Exception {
//        Board board = service.read(boardNo);
//
//        return new ResponseEntity<Board>(board, HttpStatus.OK);
//    }
//}