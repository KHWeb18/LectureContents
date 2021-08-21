package com.example.demo.service.crawling;

import com.example.demo.entity.crawling.IndieNews;
import com.example.demo.repository.crawling.IndieNewsRepository;
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
public class IndieNewsCrawlServiceImpl implements IndieNewsCrawlService {

    @Autowired
    IndieNewsRepository indieNewsRepository;

    private Document document;

    @Override
    public Document connectUrl(String url) {
        log.info("connectURL(): " + url);

        try {
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) " +
                            "Chrome/86.0.4240.277 Whale/2.9.118.38 Safari/537.36").execute();

            document = homepage.parse();
        } catch (Exception e) {
            log.info("Error in daumNewsMainCrawler");
        }
        return document;
    }

    @Override
    public List<IndieNews> indieNewsFindAll() {
        log.info("indieNewsFindAll()");

        return indieNewsRepository.findAll();
    }

    @Override
    public void indieNewsMainCrawler(String keyword) {
        log.info("indieNewsMainCrawler()");

        document = connectUrl("https://search.daum.net/search?w=news&nil_" +
                "search=btn&DA=NTB&enc=utf8&cluster=y&cluster_page=1&q=" + keyword);

        indieNewsRepository.deleteAll(); //여기서 왜 delete를 해주지??

        indieNewsCrawling(document.select("ul.list_news>li>div.wrap_cont>a"), keyword);
    }

    @Override
    public void indieNewsCrawling(Elements elements, String keyword) {
        log.info("indieNewsCrawling(): elements - " + elements + ", keyword - " + keyword);

        IndieNews indieNews = null;

        for(int i=0; i<elements.size(); i++) {
            indieNews = new IndieNews();

            indieNews.setNewsNo(String.valueOf(indieNewsRepository.findAll().size() + 1));
            indieNews.setAddress(elements.get(i).attr("href"));
            indieNews.setKeyword(keyword);
            indieNews.setTitle(elements.get(i).text());

            indieNewsRepository.save(indieNews);
        }
    }
}
