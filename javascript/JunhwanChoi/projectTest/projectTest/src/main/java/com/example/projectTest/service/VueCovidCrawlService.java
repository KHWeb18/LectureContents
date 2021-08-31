package com.example.projectTest.service;


import com.example.projectTest.entity.Covid;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public interface VueCovidCrawlService {
    public Document connectUrl(String url);
    public List<Covid> covidFindAll();
    public void covidMainCrawler(String covidcategory);
    public void covidCrawling(Elements elements, String covidcategory);
}