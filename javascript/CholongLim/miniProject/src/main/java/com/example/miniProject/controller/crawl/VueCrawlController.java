package com.example.miniProject.controller.crawl;

import com.example.miniProject.entity.Tour;
import com.example.miniProject.service.VueTourCrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Crawler")
@CrossOrigin(origins = "http://localHost:8080", allowedHeaders = "*")
public class VueCrawlController {

    @Autowired
    VueTourCrawlService service;

    @GetMapping("{category}")
    public List<Tour> getDaumNewsCategory(@PathVariable String category) {
        log.info("Crawling with getTourCategory(): " + category);

        service.TourMainCrawler(category);

        return service.TourFindAll();
    }
}
