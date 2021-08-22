package com.example.miniProject.controller.board.jpa;


import com.example.miniProject.controller.board.BoardController;
import com.example.miniProject.entity.jpa.Board;
import com.example.miniProject.entity.jpa.BoardDto;
import com.example.miniProject.repository.jpa.JPABoardRepository;
import com.example.miniProject.service.jpa.JPABoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPABoardController {

    @Autowired
    private JPABoardService service;
    public JPABoardController(JPABoardService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<BoardDto> register(@Validated @RequestBody BoardDto boardDto) throws Exception {
        log.info("post register request from vue");

        service.register(boardDto);

        return new ResponseEntity<>(boardDto, HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<BoardDto>> getLists (Model model) throws Exception {
        List<BoardDto> boardDtoList = service.list();
        model.addAttribute("boardList", boardDtoList);
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

//    @GetMapping("/{boardNo}")
//    public ResponseEntity<Board> detail(@PathVariable("boardNo") Long boardNo,Model model) throws Exception {
//        Board board = service.read(boardNo);
//        model.addAttribute("board", board);
//        return new ResponseEntity<Board>(board, HttpStatus.OK);
//    }

    @GetMapping("/{boardNo}")
    public ResponseEntity<BoardDto> detail(@PathVariable("boardNo") Long boardNo,Model model) throws Exception {
        BoardDto boardDto = service.read(boardNo);
        model.addAttribute("boardDto", boardDto);
        return new ResponseEntity<BoardDto>(boardDto, HttpStatus.OK);
    }


    @PutMapping("/{boardNo}")
    public ResponseEntity<BoardDto> modify(
            @PathVariable("boardNo") Long boardNo,
            @Validated @RequestBody
                    BoardDto boardDto) throws Exception {
        boardDto.setBoardNo(boardNo);
        log.info("modify");
        service.register(boardDto);
//        model.addAttribute("boardDto", boardDto);
        return new ResponseEntity<>(boardDto, HttpStatus.OK);
    }

//    @PutMapping("/{boardNo}")
//    public ResponseEntity<Board> modify(@PathVariable("boardNo") Long boardNo,
//                                        @Validated @RequestBody Board board ) throws Exception {
//
//        service.modify(board);
//
//        return new ResponseEntity<>(board, HttpStatus.OK);
//    }


    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> remove(@PathVariable("boardNo") Long boardNo) throws Exception {
        service.remove(boardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<BoardDto>> search(
//            @RequestParam(value = "keyword") String keyword, Model model) throws Exception {
//        List<BoardDto> boardDtoList = service.search(keyword);
//        model.addAttribute("boardList", boardDtoList);
//        log.info("getLists(): " + service.search(keyword));
//
//        return new ResponseEntity<>(service.search(keyword),HttpStatus.OK);
//    }

}



//
//    @GetMapping("/list/page")
//    public ResponseEntity<Void> remove(@PathVariable("boardNo") Long boardNo) throws Exception {
//        Page<Board> pagingResult = service.getList(pageNum);
//    }
//
//  }