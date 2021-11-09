package com.example.demo.controller.crawl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class lianxue {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://weather.naver.com/").get();

        Elements elements = document.select(".today_weather>.weather_area>.current");

        String[] str = elements.text().split("");
        List<String> st = Collections.singletonList(elements.text());
        String s = elements.text();

        System.out.println(st.get(0));

        System.out.println(s);

        for (int i = 0; i < str.length; i++) {
            System.out.printf(str[i]);
        }


    }

}
