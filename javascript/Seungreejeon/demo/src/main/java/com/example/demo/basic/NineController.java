package com.example.demo.basic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(value = "/css")
public class NineController {

    @GetMapping("/percentTest")
    public String getPercentTest() {
        log.info("getPercentTest()");

        return "/cssTest/nine/percentTest";
    }

    @GetMapping("/transparencyTest")
    public String getTransparencyTest() {
        log.info("getTranspancyTest()");

        return "/cssTest/nine/transparencyTest";
    }

    @GetMapping("/BackgroundClipTest")
    public String getBackgroundClipTest() {
        log.info("getBackgroundClipTest()");

        return "/cssTest/nine/backgroundClipTest";
    }

    @GetMapping("/gradientTest")
    public String getGradientTest() {
        log.info("getGradientTest()");


        return "/cssTest/nine/gradientTest";
    }

    @GetMapping("/customBoxTest")
    public String getCustomBoxTest() {
        log.info("getCustomBoxTest()");

        return "/cssTest/nine/customBoxTest";
    }



    @GetMapping("/InlineBlockTest")
    public String getInlineBlockTest() {
        log.info("getInlineBlockTest()");

        return "/cssTest/nine/InlineBlockTest";
    }

    @GetMapping("/NavigationBarTest")
    public String getNavigationBarTest() {
        log.info("getNavigationBarTest()");

        return "/cssTest/nine/navigationBarTest";
    }

    @GetMapping("/ParentChildTest")
    public String getParentChildTest() {
        log.info("getParentChildTest()");

        return "/cssTest/nine/ParentChildTest";

    }

    @GetMapping("/backgroundTest")
    public String getBackgroundTest() {
        log.info("getBackgroundTest()");

        return "/cssTest/nine/backgroundTest";

    }
}
