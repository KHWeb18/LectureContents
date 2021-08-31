/*
package com.example.projectTest.controller;

import com.example.projectTest.entity.Covid;
import com.example.projectTest.service.VueCovidCrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/covidtest")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueCovidCrawlController {

    @Autowired
    VueCovidCrawlService service;

    @GetMapping("/{covidcategory}")
    public List<Covid> getCovidCategory(@PathVariable String covidcategory) {
        log.info("Crawling with getDaumNewsCategory(): " + covidcategory);

        service.covidMainCrawler(covidcategory);

        return service.covidFindAll();
    }
}
*/
