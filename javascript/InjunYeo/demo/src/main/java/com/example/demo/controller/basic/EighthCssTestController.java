package com.example.demo.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
//해당 컨트롤러를 사용할때 무조건 URL 위치가 기본적으로 /css가 들어감
@RequestMapping(value = "/css")
public class EighthCssTestController {

    //결국 애는 /css/basicTest와 같음음
   @GetMapping("/basicTest")
    public String getBasicCssTest(){
        log.info("getBasicCssTest()");

        return "csstest/eighth/cssTest";
    }

    @GetMapping("/styleTest")
    public String getStyleTest(){
       log.info("getStyleTest()");

       return "csstest/eighth/styleTest";
    }

    @GetMapping("/marginTest")
    public String getMarginTest(){
       log.info("getMarginTest()");

       return "csstest/eighth/marginTest";
    }

    @GetMapping("/idSelectTest")
    public String getIdSelectTest(){
       log.info("getIdSelectTest()");

       return "csstest/eighth/idSelectTest";
    }

    @GetMapping("/allTest")
    public String getAllTest(){
        log.info("getAllTest()");

        return "csstest/eighth/allTest";
    }

    @GetMapping("/classSelectTest")
    public String getclassSelectTest(){
        log.info("getclassSelectTest()");

        return "csstest/eighth/classSelectTest";
    }

    @GetMapping("/tagClassSelectTest")
    public String getTagClassSelectTest(){
        log.info("getTagClassSelectTest()");

        return "csstest/eighth/tagclassSelectTest";
    }

    @GetMapping("/boxTest")
    public String getboxTest(){
        log.info("getboxTest()");

        return "csstest/eighth/boxTest";
    }

    @GetMapping("/boxHoverTest")
    public String getboxHoverTest(){
        log.info("getboxHoverTest()");

        return "csstest/eighth/boxHoverTest";
    }

    @GetMapping("/fontTest")
    public String getFontTest(){
        log.info("getFontTest()");

        return "csstest/eighth/fontTest";
    }

    @GetMapping("/shadowTest")
    public String shadowTest(){
        log.info("shadowTest()");

        return "csstest/eighth/shadowTest";
    }

    @GetMapping("/movieFeelShadowTest")
    public String getMovieFeelShadowTest(){
       log.info("movieFeelShadowTest()");

       return "csstest/eighth/movieFeelShadowTest";
    }

    @GetMapping("/textAlignTest")
    public String textAlignTest(){
        log.info("textAlignTest()");

        return "csstest/eighth/textAlignTest";
    }



}
