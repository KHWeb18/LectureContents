package com.example.jsmain.controller.crawl;

import com.example.jsmain.entity.DaumNews;
import com.example.jsmain.service.VueDaumNewsCrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueCrawlController {

    @Autowired
    VueDaumNewsCrawlService service;

    @GetMapping("{category}")
    public List<DaumNews> getDaumNewsCategory(@PathVariable String category) {
        log.info("Crawling with getDaumNewsCategory(): " + category);

        service.daumNewsMainCrawler(category);

        return service.daumNewsFindAll();
    }
}