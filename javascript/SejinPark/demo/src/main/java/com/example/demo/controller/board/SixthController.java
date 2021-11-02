package com.example.demo.controller.board;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j

@RestController
public class SixthController {
    @GetMapping("/jsonTest")
    public String getJsonTest () {
        return "I'm JSON!!!!";
    }
    @GetMapping("/jsonKeyValueTest")
    public String getJsonKeyValueTest () {

                String jsonString = "{\"title\":\"hihi\"," +
                "\"draft\":false," +
                "\"star\":5" +
                "}";

        JSONObject jObj = new JSONObject(jsonString);
        String title = jObj.getString("title");
        Boolean draft = jObj.getBoolean("draft");
        Integer star = jObj.getInt("star");
        log.info("title: " + title + ", draft: " + draft + ", star: " + star);
        return jsonString;
    }
    @GetMapping("/jsonMultiObjectTest")
    public String getJsonMultiObjectTest () {
        String jsonString = "{" +
                "\"movie1\": {" +
                "\"title\": \"hihi\", " +
                "\"draft\": false, " +
                "\"star\": 5" +
                "}, " +
                "\"movie2\": {" +
                "\"title\": \"code monkey\", " +
                "\"draft\": false, " +
                "\"star\": 5" +
                "}" +
                "}";

        JSONObject jObj = new JSONObject(jsonString);

        JSONObject movie1Obj = jObj.getJSONObject("movie1");
        log.info("movie1: " + movie1Obj.toString() +
                "\ntitle: " + movie1Obj.getString("title") +
                ", draft: " + movie1Obj.getBoolean("draft") +
                ", star: " + movie1Obj.getInt("star"));

        JSONObject movie2Obj = jObj.getJSONObject("movie2");
        log.info("movie2: " + movie2Obj.toString() +
                "\ntitle: " + movie2Obj.getString("title") +
                ", draft: " + movie2Obj.getBoolean("draft") +
                ", star: " + movie2Obj.getInt("star"));

        return jsonString;
    }

    @GetMapping("/jsonArrayTest")
    public String getJsonPowerTest () {
        String jsonString = "{" +
                "\"movies\": [" +
                "{" +
                "\"title\": \"hihi\", " +
                "\"draft\": false, " +
                "\"star\": 5" +
                "}, " +
                "{" +
                "\"title\": \"code monkey\", " +
                "\"draft\": false, " +
                "\"star\": 5" +
                "}, " +
                "{" +
                "\"title\": \"monkey magic\", " +
                "\"draft\": false, " +
                "\"star\": 4.7" +
                "}" +
                "]" +
                "}";

        JSONObject jObj = new JSONObject(jsonString);
        JSONArray jArr = jObj.getJSONArray("movies");

        for (int i = 0; i < jArr.length(); i++) {
            JSONObject obj = jArr.getJSONObject(i);

            String title = obj.getString("title");
            Boolean draft = obj.getBoolean("draft");
            Float star = obj.getFloat("star");

            log.info("title: " + title + ", draft: " + draft + ", star: " + star);
        }

        return jsonString;
    }
}