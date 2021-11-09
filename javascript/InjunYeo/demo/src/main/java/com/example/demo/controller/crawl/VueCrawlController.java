package com.example.demo.controller.crawl;


import com.example.demo.entity.DaumNews;
import com.example.demo.service.VueDaumNewsCrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class VueCrawlController {

    @Autowired
    VueDaumNewsCrawlService service;

    @GetMapping("{category}")
    public List<DaumNews> getDaumNewsCategory(@PathVariable String category){
        log.info("Crawiling with getDaumNewsCategory() : " +category);


        service.daumNewsMainCrawler(category);

        return service.daumNewsFindAll();


    }


}
