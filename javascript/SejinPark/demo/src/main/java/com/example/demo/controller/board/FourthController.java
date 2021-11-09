package com.example.demo.controller.board;
import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Slf4j
@Controller
public class FourthController {

    @Autowired
    private BoardService service;
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
    }