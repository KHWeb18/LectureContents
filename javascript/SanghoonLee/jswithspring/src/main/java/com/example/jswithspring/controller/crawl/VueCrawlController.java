package com.example.jswithspring.controller.crawl;

import com.example.jswithspring.entity.DaumNews;
import com.example.jswithspring.service.VueDaumNewsCrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/daumCrawler")
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
