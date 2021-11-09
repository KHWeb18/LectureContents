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

        return "first/list";
    }

    @GetMapping("/imageTest")
    public String doImageTest(){
        log.info("doImageTest()");

        return "first/image";
    }

    @GetMapping("/fontTest")
    public String doFontTest(){
        log.info("doFontTest()");

        return "first/font";
    }

    @GetMapping("/markTest")
    public String doMarkTest(){
        log.info("doMarkTest()");

        return "first/mark";
    }

    @GetMapping("/tableTest1")
    public String doTableTest1(){
        log.info("doTableTest1()");

        return "first/tableTest1";
    }

    @GetMapping("/tableTest2")
    public String doTableTest2(){
        log.info("doTableTest2()");

        return "first/tableTest2";
    }

    @GetMapping("/tableTest3")
    public String doTableTest3(){
        log.info("doTableTest3()");

        return "first/tableTest3";
    }
    @GetMapping("/firstTask")
    public String doFirstTask(){
        log.info("doFirstTask()");

        return "first/todayTask";
    }
}
