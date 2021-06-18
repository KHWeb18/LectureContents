package com.example.demo.controller.board;
import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Slf4j
@Controller
public class FourthController {
    // @Autowired > 스프링이 자동으로 객체를 찾을 수 있게 support
    @Autowired
    private BoardService service;
    // thymeleaf에서는 아래와 같이 특정한 객체를 입력으로 받으면
    // HTML에서 th:object와 같은 키워드를 통해 정보를 획득할 수 있다.
    // 즉 board 객체의 정보를 획득할 수 있음을 의미.
    @GetMapping("/register")
    public String getRegister (Board board, Model model){
                // Model은 Spring 내부에 있어서 상관 없는데
                // Board는 entity로 따로 만들어줘야 한다.
                // entity의 사전적의미 : 독립체
        log.info("getRegister()");
        return "/board/Fourth_20210617/register";
    }

    @PostMapping("/register")
    public String postRegister (Board board, Model model) throws Exception {
        log.info("postRegister()");
        service.register(board);
        model.addAttribute("msg","등록이 완료되었습니다");
            // 'msg' 전달을 위한 코드
            // key: msg, value: "등록이 완료되었습니다" 라고 생각하면 편할듯
        return "/board/Fourth_20210617/success";
    }
}
// Post방식은 data를 어떤 식으로 관리하는가 > json
// json 형식은 data형식이 hashmap 같은 느낌으로 전송됨
//  그렇다면 PostMappin을 쓰면 좋은점?
// GetMapping으로 하면 id/비밀번호 같은게 다 url에 나옴
// PostMapping은 json의 data형식으로 나가기 때문에 보호됨.
