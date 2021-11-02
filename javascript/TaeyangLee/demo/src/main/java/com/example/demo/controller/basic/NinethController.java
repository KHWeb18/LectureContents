package com.example.demo.controller.basic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

@Slf4j
@Controller
@RequestMapping(value = "/css")
public class NinethController {

    @GetMapping("/getPercentTest")
    public String getPercentTest()  {
        log.info("getPercentTest()");


        return "/cssTest/nineth/percentTest";
    }

    @GetMapping("/getTransparencyTest")
    public String getTransparencyTest()  {
        log.info("getTransparencyTest()");


        return "/cssTest/nineth/transparencyTest";
    }

    @GetMapping("/getBackgroundClipTest")
    public String getBackgroundClipTest()  {
        log.info("getBackgroundClipTest()");


        return "/cssTest/nineth/backgroundClipTest";
    }

    @GetMapping("/getGradientTest")
    public String getGradientTest()  {
        log.info("getGradientTest()");


        return "/cssTest/nineth/gradientTest";
    }

    @GetMapping("/customBoxTest")
    public String getcustomBoxTest()  {
        log.info("getcustomBoxTest()");


        return "/cssTest/nineth/customBoxTest";
    }



    @GetMapping("/getInlineBlockTest")
    public String getInlineBlockTest()  {
        log.info("getInlineBlockTest()");


        return "/cssTest/nineth/inlineBlockTest";
    }
    @GetMapping("/getNavigationBarTest")
    public String getNavigationBarTest()  {
        log.info("getNavigationBarTest()");


        return "/cssTest/nineth/navigationBarTest";
    }

    @GetMapping("/getParentChildTest")
    public String getParentChildTest()  {
        log.info("getParentChildTest()");


        return "/cssTest/nineth/parentChildTest";
    }

    @GetMapping("/getBackgroundUrlTest")
    public String getBackgroundUrlTest()  {
        log.info("getBackgroundUrlTest()");


        return "/cssTest/nineth/backgroundUrlTest";
    }







}
