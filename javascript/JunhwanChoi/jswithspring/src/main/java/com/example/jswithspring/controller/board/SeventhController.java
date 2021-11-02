package com.example.jswithspring.controller.board;

import com.example.jswithspring.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class SeventhController {

    @Autowired
    private BoardService service;

    @GetMapping("/read")
    public String getRead (int boardNo, Model model) throws Exception {
        log.info("read");

        // read가 리턴하는 결과는 무엇인가 ? Board 객체(Board 클래스의 메모리 적재 상태)
        // 클래스는 앞대가리 및 이니셜이 대문자
        // 클래스가 아닌 일반 변수들(객체 포함)
        // 앞대가리가 소문자고 이니셜은 대문자임 <<<<----
        // SignUp ---> signUp O    (SignUp x) <<<--- 인식 못함
        model.addAttribute(service.read(boardNo));

        return "board/seventh/read";
    }

    // 글을 지워도 숫자가 올라가야만 하는 이유가 무엇인가 ?
    // 배열 100개에서 중간의 값을 지우는 경우
    @PostMapping("/remove")
    public String remove (int boardNo, Model model) throws Exception {
        log.info("remove");

        service.remove(boardNo);

        model.addAttribute("msg", "삭제가 완료되었습니다!");

        return "board/fourth/success";
    }
}
