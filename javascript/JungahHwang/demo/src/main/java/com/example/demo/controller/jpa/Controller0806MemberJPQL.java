package com.example.demo.controller.jpa;

import com.example.demo.service.jpa.MemberJPQLService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
public class Controller0806MemberJPQL {

    @Autowired
    private MemberJPQLService service;

    @GetMapping("/jpql")
    public void getJPATest () throws Exception{
        log.info("getJPATest(findByJPQL): " + service.findByJPQL());

        List<Object[]> resultLists = service.findSpecificJPQL();

        for (Object [] result : resultLists) {
            log.info("getJPATest(findSpecificJPQL): " + Arrays.toString(result));
        }
    }
}

















