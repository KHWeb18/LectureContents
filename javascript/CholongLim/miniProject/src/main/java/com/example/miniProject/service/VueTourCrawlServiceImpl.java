package com.example.miniProject.service;

import com.example.miniProject.entity.Tour;
import com.example.miniProject.repository.TourRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Iterator;
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
            log.info("Error in TourMainCrawler");
        }

        return document;
    }

    @Override
    public List<Tour> TourFindAll() {
        log.info("TourFindAll()");

        return tourRepository.findAll();
    }

    /*
    @Override
    public void daumNewsHomeCrawling() {
        log.info("daumNewsHomeCrawling()");
        daumNewsHomeRepository.deleteAll();
        document = connectUrl("https://news.daum.net/");
        Elements total = document.select("strong.tit_thumb>a.link_txt");
        Elements image = document.select("div.item_issue>a.link_thumb>img.thumb_g");
        DaumNewsHome dnh = null;
        for (int i = 0; i < total.size(); i++) {
            dnh = new DaumNewsHome();
            dnh.setDaumNewsHomeNo(String.valueOf(i + 1));
            dnh.setTitle(total.get(i).text());
            dnh.setAddress(total.get(i).attr("href"));
            dnh.setImage(image.get(i).attr("src"));
            daumNewsHomeRepository.save(dnh);
        }
    }
     */

    @Override
    public void TourMainCrawler(String category) {
        log.info("TourMainCrawler()");

        document = connectUrl("https://www.visitjeju.net/kr/" + category);

        tourRepository.deleteAll();

        TourCrawling(document.select(
                "ul.item_list>li>dl.item_section>dt.item_top>a"), category);
        TourCrawling(document.select(
                "ul.item_list type_thumb>li>dl.item_section>dt.item_top>a"), category);
        TourCrawling(document.select(
                "li>dl.item_section>dt.item_top>a>div.score_area>p"), category);
        TourCrawling(document.select(
                "li>dl.item_section>dt.item_top>a"), category);
//        TourCrawling(document.select(
//                "dl.item_section>dt.item_top>a>div.score_area>p.s_tit"), category);
//        TourCrawling(document.select(
//                "ul.list_ranking>li>span.cont_thumb>strong.tit_thumb>a"), category);

    }

    @Override
    public void TourCrawling(Elements elements, String category) {
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