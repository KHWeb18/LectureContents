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
    public String doimageTest(){
        log.info("doimageTest()");

        return "first/image.html";
    }

    @GetMapping("/fontTest")
    public String dofontTest(){
        log.info("doFontTest()");

        return "first/font";
    }

    @GetMapping("/markTest")
    public String domarkTest(){
        log.info("domarkTest()");

        return "first/mark";
    }

    @GetMapping("/firstTableTest")
    public String firstTableTest(){
        log.info("firstTableTest()");

        return "first/tableTest1";
    }

    @GetMapping("/secondTableTest")
    public String secondTableTest(){
        log.info("secondTableTest()");

        return "first/tableTest2";
    }

    @GetMapping("/Resume")  //  Url을 맵핑한다 설정하는 부분 @GetMapping()을 통해서 설정한다
    public String Resume(){
        log.info("Resume()"); //Resume페이지에 들어갈때마다 Run창에 표시된다

        return "first/resume"; // first 폴더에 있는 resume파일을 불러온다
    }
}
