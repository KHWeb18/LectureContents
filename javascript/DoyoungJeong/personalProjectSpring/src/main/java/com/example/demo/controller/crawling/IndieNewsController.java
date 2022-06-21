package com.example.demo.controller.crawling;

import com.example.demo.entity.crawling.IndieNews;
import com.example.demo.service.crawling.IndieNewsCrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class IndieNewsController {

    @Autowired
    IndieNewsCrawlService service;

    @GetMapping("{keyword}")
    public List<IndieNews> getIndieNewsCrawl(@PathVariable("keyword") String keyword) {
        log.info("getIndieNewsCrawl():");

        service.indieNewsMainCrawler(keyword);

        return service.indieNewsFindAll();
    }
}
