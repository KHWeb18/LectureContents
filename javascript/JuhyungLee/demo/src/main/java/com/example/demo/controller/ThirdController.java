package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ThirdController {
        @GetMapping("/checkbox")
        public String tryCheckbox(){
                log.info("tryCheckbox()");
                return "Third_20210616/checkbox";
    }

        @GetMapping("/radio")
        public String tryRadio(){
            log.info("radio is running");
            return "/Third_20210616/radio"; // 여기 뒤에 .html 안 넣어줘도 되는 이유가 thymeleaf때문임
        }

        @GetMapping("/formRadio")
        public String whatisformRadio(){
            log.info("formRadio is running");
            return "/Third_20210616/formRadio";
        }
            @GetMapping("/test")
            public String testFromFormRadio(){
                log.info("testFromFormRadio");
                return "redirect:/";
            }

    @GetMapping("/fieldsetLogin")
    public String fieldsetLoginTest(){
        log.info("fieldsetLogin testing");
        return "/Third_20210616/fieldsetLogin";
    }

    @GetMapping("/numberRange")
    public String numberRangeTest(){
        log.info("numberRange testing");
        return "/Third_20210616/numberRange";
    }

    @GetMapping("/button")
    public String buttonTest(){
        log.info("button testing");
        return "/Third_20210616/button";
    }

    @GetMapping("/selectPage")
    public String selectTest(){
        log.info("select testing");
        return "/Third_20210616/select";
    }

    @GetMapping("/optgroupPage")
    public String optgroupTest(){
        log.info("optgroup testing");
        return "/Third_20210616/optgroup";
    }
}
