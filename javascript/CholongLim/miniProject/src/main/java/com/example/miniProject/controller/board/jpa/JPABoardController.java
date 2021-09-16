package com.example.miniProject.controller.board.jpa;


import com.example.miniProject.entity.jpa.Board;
import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.repository.jpa.JPABoardRepository;
import com.example.miniProject.service.jpa.JPABoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;


import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPABoardController {

    @Autowired
    private JPABoardService service;

    @Autowired
    private JPABoardRepository boardRepository;


//    @GetMapping("/lists")
//    public ResponseEntity<List<Board>> getLists (@PageableDefault(size=2) @RequestParam(required = false,defaultValue = "")
//                                                      String searchText, Model model) throws Exception {
//        model.addAttribute("boards", service.list(searchText,searchText));
//        return new ResponseEntity<>(service.list(searchText,searchText), HttpStatus.OK);
//    }
    @GetMapping("/lists")
    public ResponseEntity<List<Board>> getLists () throws Exception {
        log.info("getLists(): " + service.list());
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Board> register(@Validated @RequestBody Board board) throws Exception {
        log.info("post register request from vue");

        service.register(board);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }


    @GetMapping("/{boardNo}")
    public ResponseEntity<Board> read(@PathVariable("boardNo") Long boardNo) throws Exception {
        Board board = service.read(boardNo);

        return new ResponseEntity<Board>(board, HttpStatus.OK);
    }

    @PutMapping("/{boardNo}")
    public ResponseEntity<Board> modify(@PathVariable("boardNo") Long boardNo,
                                        @Validated @RequestBody Board board ) throws Exception {


        Optional<Board> modifyBoard = boardRepository.findById(boardNo);

        modifyBoard.ifPresent( changeBoard ->{
            changeBoard.setTitle(board.getTitle());
            changeBoard.setContent(board.getContent());
            board.setBoardNo(boardNo);
            boardRepository.save(changeBoard);
        });

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> remove(@PathVariable("boardNo") Long boardNo) throws Exception {
        service.remove(boardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}



