//package com.example.cholongtest.controller.crawl;
//
//import com.example.cholongtest.entity.DaumNews;
//import com.example.cholongtest.service.VueDaumNewsCrawlService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Slf4j
//@RestController
////@RequestMapping("/daumCrawler")
//@CrossOrigin(origins = "http://localHost:8080", allowedHeaders = "*")
//public class VueCrawlController {
//
//    @Autowired
//    VueDaumNewsCrawlService service;
//
//    @GetMapping("{category}")
//    public List<DaumNews> getDaumNewsCategory(@PathVariable String category) {
//        log.info("Crawling with getDaumNewsCategory(): " + category);
//
//        service.daumNewsMainCrawler(category);
//
//        return service.daumNewsFindAll();
//    }
//}
