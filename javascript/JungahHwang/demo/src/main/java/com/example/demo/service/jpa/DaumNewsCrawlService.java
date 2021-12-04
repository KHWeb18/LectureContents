package com.example.demo.service.jpa;

import com.example.demo.entity.jpa.DaumNews;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public interface DaumNewsCrawlService {
    // jsoup Document 사용(크롤링을 위함)
    public Document connectUrl(String url);
    public List<DaumNews> daumNewsFindAll();
    // daumNewsHomeFindAll();
    // public void daumNewsHomeCrawling();
    public void daumNewsMainCrawler(String category);
    // jsoup Elements 사용
    public void daumNewsCrawling(Elements elements, String category);
    // pickOneDaumNewsCrawling(String newsNo);

}
