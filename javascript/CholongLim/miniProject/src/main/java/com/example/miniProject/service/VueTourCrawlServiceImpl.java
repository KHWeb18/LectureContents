package com.example.miniProject.service;


import com.example.miniProject.entity.jpa.Tour;
import com.example.miniProject.repository.TourRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j

public class VueTourCrawlServiceImpl implements VueTourCrawlService {
    @Autowired
    TourRepository tourRepository;

    private Document document;

    @Override
    public Document connectUrl(String url) {
        log.info("connectURL(): " + url);

        try {
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                            "AppleWebKit/537.36 (KHTML, like Gecko) " +
                            "Chrome/92.0.4515.107 " +
                            "Safari/537.36")
                    .execute();

            document = homepage.parse();
        } catch (Exception e) {
            log.info("Error in daumNewsMainCrawler");
        }

        return document;
    }

    @Override
    public List<Tour> tourFindAll() {
        log.info("tourFindAll()");

        return tourRepository.findAll();
    }



    @Override
    public void tourMainCrawler(String category) {
        log.info("tourMainCrawler()");

        document = connectUrl("https://search.naver.com/search.naver?where=view&sm=tab_jum&query=" + category);
        tourRepository.deleteAll();
        tourCrawling(document.select(
                "div.total_area>a"), category);



    }

    @Override
    public void tourCrawling(Elements elements, String category) {
        log.info("TourCrawling(): elements - " + elements + ", category - " + category);

        Tour tour = null;

        for (int i = 0; i < elements.size(); i++) {
            tour = new Tour();

            tour.setTourNo(String.valueOf(tourRepository.findAll().size() + 1));
            tour.setAddress(elements.get(i).attr("href"));
            tour.setCategory(category);
            tour.setTitle(elements.get(i).text());


            tourRepository.save(tour);
        }
    }
}


