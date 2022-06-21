package com.example.demo.service.crawling;

import com.example.demo.entity.crawling.IndieNews;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.text.Element;
import java.util.List;

public interface IndieNewsCrawlService {
    public Document connectUrl(String url);
    public List<IndieNews> indieNewsFindAll();
    public void indieNewsMainCrawler(String keyword);
    public void indieNewsCrawling(Elements elements, String keyword);
}
