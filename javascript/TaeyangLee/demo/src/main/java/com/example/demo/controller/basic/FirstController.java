package com.example.demo.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FirstController {
    @GetMapping("/htmlList")
    public String doHtmlList(){
        log.info("doHtmlList()");

        return "first/list.html";
    }

    @GetMapping("/imageTest")
    public String doImageTest(){
        log.info("doimageTest()");

        return "first/image.html";
    }

    @GetMapping("/fontTest")
    public String dofontTest(){
        log.info("dofontTest()");

        return "first/font.html";
    }
    @GetMapping("/markTest")
    public String domarkTest(){
        log.info("domarkTest()");

        return "first/mark.html";
    }

    @GetMapping("/tableTest1")
    public String doTableTest1(){
        log.info("doTableTest1()");

        return "first/tableTest1.html";
    }

    @GetMapping("/tableTest2")
    public String doTableTest2(){
        log.info("doTableTest2()");

        return "first/tableTest2.html";
    }

    @GetMapping("/tableTest3")
    public String doTableTest3(){
        log.info("doTableTest3()");

        return "first/tableTest3.html";
    }

    @GetMapping("/Prob64")
    public String doProb64(){
        log.info("doProb64()");

        return "first/Prob64.html";
    }

}
