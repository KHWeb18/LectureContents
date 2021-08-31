package com.example.projectTest.service;

import com.example.projectTest.entity.Covid;
import com.example.projectTest.repository.CovidRepository;
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
public class VueCovidCrawlServiceImpl implements VueCovidCrawlService {

    @Autowired
    CovidRepository covidRepository;

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
            log.info("Error in covidMainCrawler");
        }

        return document;
    }

    @Override
    public List<Covid> covidFindAll() {
        log.info("covidFindAll()");

        return covidRepository.findAll();
    }


    @Override
    public void covidMainCrawler(String covidcategory) {
        log.info("covidMainCrawler()");

        document = connectUrl("http://news.daum.net/covid19/" + covidcategory);


        covidRepository.deleteAll();

        covidCrawling(document.select(
                "ul.list_status>li.status_r>span.txt_count>span.data_diff"), covidcategory);


    }

    @Override
    public void covidCrawling(Elements elements, String covidcategory) {
        log.info("covidCrawling(): elements - " + elements + ", covidcategory - " + covidcategory);

        Covid cnt = null;

        for (int i = 0; i < elements.size(); i++) {
            cnt = new Covid();

            cnt.setCovidNo(String.valueOf(covidRepository.findAll().size() + 1));
            cnt.setCovidcategory(covidcategory);
            cnt.setTodayCnt(elements.get(i).text());

            covidRepository.save(cnt);
        }
    }


}