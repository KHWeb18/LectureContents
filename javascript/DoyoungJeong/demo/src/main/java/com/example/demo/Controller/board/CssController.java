package com.example.demo.controller.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/static/css") //이걸 localhost:7777/뒤에 붙여주어야한다.
public class CssController {

    @GetMapping("/basicTest")
    public String getBasicTest() {
        log.info("getBasicTest()");

        return "cssTest/eighth/cssTest";
    }

    @GetMapping("/styleTest")
    public String getStyleTest() {
        log.info("getStyleTest()");

        return "cssTest/eighth/styleTest";
    }

    @GetMapping("/marginTest")
    public String getMarginTest() {
        log.info("getMarginTest()");

        return "cssTest/eighth/marginTest";
    }

    @GetMapping("/idSelectTest")
    public String getIdSelectTest() {
        log.info("getIdSelectTest()");

        return "cssTest/eighth/idSelectTest";
    }

    @GetMapping("/allTest")
    public String getAllTest() {
        log.info("getAllTest()");

        return "cssTest/eighth/allTest";
    }

    @GetMapping("/classSelectTest")
    public String getClassSelectTest() {
        log.info("getClassSelectTest()");

        return "cssTest/eighth/classSelectTest";
    }

    @GetMapping("/tagClassSelectTest")
    public String getTagClassSelectTest() {
        log.info("getTagClassSelectTest()");

        return "cssTest/eighth/tagClassSelectTest";
    }

    @GetMapping("/fontTest")
    public String getFontTest() {
        log.info("getFontTest()");

        return "cssTest/eighth/fontTest";
    }

    @GetMapping("/shadowTest")
    public String getShadowTest() {
        log.info("getShadowTest()");

        return "cssTest/eighth/shadowTest";
    }

    @GetMapping("/movieFeelShadowTest")
    public String movieFeelShadowTest() {
        log.info("movieFeelShadowTest()");

        return "cssTest/eighth/movieFeelShadowTest";
    }

    @GetMapping("/boxTest")
    public String getBoxTest () {
        log.info("getBoxTest()");

        return "cssTest/eighth/boxTest";
    }

    @GetMapping("/textAlignTest")
    public String getTextAlignTest () {
        log.info("getTextAlignTest()");

        return "cssTest/eighth/text-alignTest";
    }

    @GetMapping("/percentageTest")
    public String getPercentageTest () {
        log.info("getPercentageTest()");

        return "cssTest/eighth/percentageTest";
    }

    @GetMapping("/transparencyTest")
    public String getTransparencyTest () {
        log.info("getTransparencyTest()");

        return "cssTest/eighth/transparencyTest";
    }

    @GetMapping("/backgroundClipTest")
    public String getBackgroundClipTest () {
        log.info("getBackgroundClipTest()");

        return "cssTest/eighth/BackgroundClipTest";
    }

    @GetMapping("/gradiantTest")
    public String getGradiantTest () {
        log.info("getGradiantTest()");

        return "cssTest/eighth/gradiantTest";
    }

    @GetMapping("/customBoxTest")
    public String getCustomBoxTest () {
        log.info("getCustomBoxTest()");

        return "cssTest/eighth/customBoxTest";
    }

    @GetMapping("/inLineBlockTest")
    public String getInLineBlockTest () {
        log.info("getInLineBlockTest()");

        return "cssTest/eighth/inLineBlockTest";
    }

    @GetMapping("/navigationTest")
    public String getNavigationTest () {
        log.info("getNavigationTest()");

        return "cssTest/eighth/navigationTest";
    }

    @GetMapping("/childParentTest")
    public String getChildParentTest () {
        log.info("getChildParentTest()");

        return "cssTest/eighth/childParentTest";
    }
}
