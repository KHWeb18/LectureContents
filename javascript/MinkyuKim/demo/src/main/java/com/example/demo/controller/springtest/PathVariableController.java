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
// 가변인자에 대한 핸들링
public class PathVariableController {

    @Autowired
    private BoardService service;


    @GetMapping("/modify")
    public String getModify (int boardNo, Model model) throws Exception {
        log.info("getModify()") ;

        model.addAttribute(service.read(boardNo));

        return "board/eighth/modify";
    }


    @PostMapping("/modify")
    public String modify (Board board, Model model) throws Exception {
        log.info("postModify()" + board);

        service.modify(board);
        model.addAttribute("msg", "수정이 완료되었습니다!");

        return  "/board/fourth/success";
    }

    @GetMapping("/lists")
    public String getLists (Model model) throws Exception {
        log.info("getLists()");

        //++ 여기서 service.list를 구동시키기 위해선?
        //++ 등록된 글들을 뿌려준다. 보드서비스에 리스트가 구현되어있어야만 작동하고 없다면 오류난다. 일시적 주석처리 후 다시 리스트 생성
        //++ 보드리포지토리를 작성했으면 주석을 열어준다.
        //++ 이게 게시물을 전달해주는것? 게시물 목록보기에?

        model.addAttribute("lists", service.list());

        return "/board/fifth/lists";
    }


    @GetMapping("/register")
    public String getRegister (Board board, Model model) {
        log.info("getRegister()");

        return "/board/fourth/register";
    }


    @PostMapping("/register")
    public String postRegister (Board board, Model model) throws Exception {
        log.info("postRegister()");

        log.info("Board: " + board);

        service.register(board);

        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/board/fourth/success";
    }

    // boardNo의 의미 : 게시물 번호 << 고정인가?
    //                 몇 번인지 알 수 없음 << 사용자가 몇 번 누를지 아무도 모름
    //                 {boardNo} + @PathVariable("boardNo") int boardNo를 통해
    //                 boardNo로 들어온 URL에 해당하는 숫자를 boardNo 입력 인자에 저장함
    @GetMapping("/read/{boardNo}")
    public String getBoardRead (@PathVariable("boardNo") int boardNo, Model model) throws Exception {
        log.info("getBoardRead()" + boardNo);

        model.addAttribute(service.read(boardNo));

        return "board/seventh/read";
    }

    @PostMapping("/remove")
    public String getBoardRemove (int boardNo, Model model) throws Exception {
        log.info("getBoardRemove()");

        service.remove(boardNo);

        model.addAttribute("msg", "삭제가 완료되었습니다!");

        return "board/fourth/success";

    }
}



