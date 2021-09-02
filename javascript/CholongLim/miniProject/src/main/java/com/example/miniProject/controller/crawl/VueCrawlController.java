package com.example.miniProject.controller.crawl;


import com.example.miniProject.entity.jpa.Tour;

import com.example.miniProject.service.VueTourCrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localHost:8080", allowedHeaders = "*")
public class VueCrawlController {

    @Autowired
    VueTourCrawlService service;

    @GetMapping("{category}")
    public List<Tour> getTourCategory(@PathVariable String category) {
        log.info("Crawling with getTourCategory(): " + category);

        service.tourMainCrawler(category);

        return service.tourFindAll();
    }
}
