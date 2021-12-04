package com.example.demo.controller.jpa;

import com.example.demo.entity.jpa.DaumNews;
import com.example.demo.service.jpa.DaumNewsCrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/daumcrwal")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Controller0728Crawl {

    @Autowired
    DaumNewsCrawlService service;

    @GetMapping("{category}")
    public List<DaumNews> getDaumNewsCategory(@PathVariable String category) {
        log.info("Crawling with getDaumNewsCategory(): " + category);

        service.daumNewsMainCrawler(category);

        return service.daumNewsFindAll();
    }
}
