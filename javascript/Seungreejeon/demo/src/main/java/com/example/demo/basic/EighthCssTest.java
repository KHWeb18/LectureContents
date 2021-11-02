package com.example.demo.basic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
// 해당 컨트롤러를 사용할 때 무조건 URL 위치가 기본적으로 /css가 들어감
@RequestMapping(value = "/css")
public class EighthCssTest {

    //이건 결국 /css/basicTest와 같음
    @GetMapping("/basicTest")
    public String getBasicCssTest() {
        log.info("getBasicCssTest()");

        return "/cssTest/eight/cssTest";
    }

    @GetMapping("/styleTest")
    public String getStyleTest() {
        log.info("getStyleTest()");

        return "/cssTest/eight/styleTest";
    }

    @GetMapping("/marginTest")
    public String getMarginTest() {
        log.info("getMarginCssTest()");

        return "/cssTest/eight/marginTest";
    }

    @GetMapping("/idSelectTest")
    public String getIdSelectTest() {
        log.info("getIdSelectTest()");

        return "/cssTest/eight/idSelectTest";
    }

    @GetMapping("/allTest")
    public String getAllTest() {
        log.info("getAllTest()");

        return "/cssTest/eight/allTest";
    }

    @GetMapping("/classSelectTest")
    public String getClassSelectTest() {
        log.info("getClassSelectTest()");

        return "/cssTest/eight/classSelectTest";
    }

    @GetMapping("/tagSelectTest")
    public String getTagSelectTest() {
        log.info("getTagSelectTest()");

        return "/cssTest/eight/tagSelectTest";
    }

    @GetMapping("/boxTest")
    public String getBoxTest() {
        log.info("getBoxTest()");

        return "/cssTest/eight/boxTest";
    }

    @GetMapping("/boxHoverTest")
    public String getBoxHoverTest() {
        log.info("getBoxHoverTest()");

        return "/cssTest/eight/boxHoverTest";
    }

    @GetMapping("/fontTest")
    public String getBoxFontTest() {
        log.info("getBoxFontTest()");

        return "/cssTest/eight/fontTest";
    }

    @GetMapping("/shadowTest")
    public String getShadowTest() {
        log.info("getShadowTest()");

        return "/cssTest/eight/shadowTest";
    }

    @GetMapping("/movieFeelShadowTest")
    public String getMovieFeelShadowTest() {
        log.info("getMovieFeelShadowTest()");

        return "/cssTest/eight/movieFeelShadowTest";
    }

    @GetMapping("/textAlignTest")
    public String getTextAlignTest() {
        log.info("getTextAlignTest()");

        return "/cssTest/eight/textAlignTest";
    }
}
