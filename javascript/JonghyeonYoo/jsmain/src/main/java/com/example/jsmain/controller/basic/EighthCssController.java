package com.example.jsmain.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.print.DocFlavor;

@Slf4j
@Controller
// 해당 컨트롤러를 사용할 때 무조건 URL 위치가 기본적으로 /css가 들어감
@RequestMapping(value = "/css")
public class EighthCssController {

    // 결국 얘는 /css/basicTest 와 같음
    @GetMapping("/basicTest")
    public String getBasicCssTest () {
        log.info("getBasicCssTest()");

        return "csstest/eighth/cssTest";
    }

    @GetMapping("/styleTest")
    public String getStyleTest () {
        log.info("getStyleTest()");

        return "csstest/eighth/styleTest";
    }

    @GetMapping("/marginTest")
    public String getMarginTest () {
        log.info("getMarginTest()");

        return "csstest/eighth/marginTest";
    }

    @GetMapping("/idSelectTest")
    public String getIdSelectTest () {
        log.info("getIdSelectTest()");

        return "csstest/eighth/idSelectTest";
    }

    @GetMapping("/allTest")
    public String getAllTest () {
        log.info("getAllTest()");

        return "csstest/eighth/allTest";
    }

    @GetMapping("/classSelectTest")
    public String getClassSelectTest () {
        log.info("getClassSelectTest()");

        return "csstest/eighth/classSelectTest";
    }

    @GetMapping("/tagClassSelectTest")
    public String getTagClassSelectTest () {
        log.info("getTagClassSelectTest()");

        return "csstest/eighth/tagClassSelectTest";
    }

    @GetMapping("/boxTest")
    public String getBoxTest () {
        log.info("getBoxTest()");

        return "csstest/eighth/boxTest";
    }

    @GetMapping("/boxHoverTest")
    public String getBoxHoverTest () {
        log.info("getBoxHoverTest()");

        return "csstest/eighth/boxHoverTest";
    }

    @GetMapping("/fontTest")
    public String getFontTest () {
        log.info("getFontTest()");

        return "csstest/eighth/fontTest";
    }

    @GetMapping("/shadowTest")
    public String getShadowTest () {
        log.info("getShadowTest()");

        return "csstest/eighth/shadowTest";
    }

    @GetMapping("/movieFeelShadowTest")
    public String getMovieFeelShadowTest () {
        log.info("getMovieFeelShadowTest()");

        return "csstest/eighth/movieFeelShadowTest";
    }

    @GetMapping("/textAlignTest")
    public String getTextAlignTest () {
        log.info("getTextAlignTest()");

        return "csstest/eighth/textAlignTest";
    }
}
