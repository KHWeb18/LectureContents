package com.example.demo.service;

import com.example.demo.entity.DaumNews;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public interface VueDaumNewsCrawlService {


    public Document connectUrl(String url);
    public List<DaumNews> daumNewsFindAll();

    //daumNewsHomeFindAll();
    //public void daumNewsHomeCrawling();
    public void daumNewsMainCrawler(String category);
    public void daumNewsCrawling(Elements elements, String category);
    //pickOneDaumNewsCrawling(String newsNo);

}
