package com.example.miniProject.service;

import com.example.miniProject.entity.Tour;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public interface VueTourCrawlService {
    public Document connectUrl(String url);
    public List<Tour> TourFindAll();
    public void TourMainCrawler(String category);
    public void TourCrawling(Elements elements, String category);

}
