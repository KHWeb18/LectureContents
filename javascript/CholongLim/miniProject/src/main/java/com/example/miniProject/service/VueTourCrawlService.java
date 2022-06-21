package com.example.miniProject.service;


import com.example.miniProject.entity.jpa.Tour;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public interface VueTourCrawlService {
    public Document connectUrl(String url);
    public List<Tour> tourFindAll();
    public void tourMainCrawler(String category);
    public void tourCrawling(Elements elements, String category);

}
