package com.example.demo.controller.springtest;

import com.example.demo.eutity.Board;
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
@RequestMapping(value = "/board")
public class PathVariableController {

    // 스프링이 자동으로 객체를 찾을 수 있게 서포트함
    @Autowired
    private BoardService service;

    // thymeleaf에서는 아래와 같이 특정한 객체를 입력으로 받으면
    // HTML에서 th:object와 같은 키워드를 통해 정보를 획득할 수 있다.
    // 즉 board 객체의 정보를 획득할 수 있음을 의미한다.
    @GetMapping("/register")
    public String getBoardRegister(Board board, Model model) {
        log.info("getBoardRegister()");

        return "/board/fourth/register";
    }

    // MVC(Model View Controller) Pattern
    // Model: 다루는 데이터
    // View: 눈에 보이는 화면
    // Controller: URL 제어

    @PostMapping("/register")
    public String postBoardRegister(Board board, Model model) throws Exception {
        log.info("postBoardRegister()");
        log.info("Board: " + board);

        service.register(board);

        // msg 라는 속성값에 "등록이 완료되었습니다!"을 맵핑함
        // key: msg, value: "등록이 완료되었습니다!" 라고 생각하면 편함
        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/board/fourth/success";
    }
    @GetMapping("/lists")
    public String getBoardLists(Model model) throws Exception{
        log.info("getBoardLists()");

        model.addAttribute("lists", service.list());

        return "/board/fifth/lists";
    }

    @GetMapping("/modify")
    public String getBoardModify(int boardNo, Model model)throws Exception{
        log.info("getBoardModify()");

        // 수정을 눌렀을때 기존 정보를 가져와야함
        model.addAttribute(service.read(boardNo));

        return "/board/eighth/modify";
    }

    @PostMapping("/modify")
    public String boardModify(Board board, Model model)throws Exception{
        log.info("postBoardModify()");

        service.modify(board);

        model.addAttribute("msg","수정이 성공적으로 완료되었습니다!");
        return "/board/fourth/success";
    }

    // boardNo : 얘는 어떤 의미?
    //          게시물 번호 << 고정인가?
    //          몇 번인지 알 수 없음 <<< 사용자가 몇 번 누를지 아무도 모름
    //          {boardNo} + @PathVariable("boardNo") int boardNo를 통해
    //          boardNo로 들어온 URL에 해당하는 숫자를 boardNo 입력 인자에 저장함
    @GetMapping("/read/{boardNo}")
    public String getBoardRead (@PathVariable("boardNo") int boardNo, Model model) throws Exception{
        log.info("getBoardRead()" + boardNo);

        model.addAttribute(service.read(boardNo));

        return "board/seventh/read";
    }

    // 글을 지워도 숫자가 올라가야만 하는 이유는??
    // 배열 100개에서 중간의 값을 지우는 경우
    //
    @PostMapping("/remove")
    public String getBoardRemove(int boardNo, Model model) throws Exception{
        log.info("getBoardRemove");

        service.remove(boardNo);

        model.addAttribute("msg", "삭제가 완료되었습니다!");

        return "board/fourth/success";
    }

}
