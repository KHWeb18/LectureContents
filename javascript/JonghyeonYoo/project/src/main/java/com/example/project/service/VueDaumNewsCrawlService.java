package com.example.project.service;

import com.example.project.entity.DaumNews;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;


public interface VueDaumNewsCrawlService {
     Document connectUrl(String url);
     List<DaumNews> daumNewsFindAll();
    // daumNewsHomeFindAll();
    // public void daumNewsHomeCrawling();
     void daumNewsMainCrawler(String category);
     void daumNewsCrawling(Elements elements, String category);
    // pickOneDaumNewsCrawling(String newsNo);
}