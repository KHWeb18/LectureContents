package com.example.demo.controller.board;


import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//Controller vs RestController의 차이점은 딱 하나다
//Controller는 HTML을 파싱하는 반면
//RestController는 json을 파싱한다.
@RestController
public class SixthController {


    @GetMapping("/jsontest")
    public String getJasonTest(){

        return "I'm JSON!!!!";
    }

    @GetMapping("/jsonKeyValueTest")
    public String getJsonKeyValueTest(){

        //모든 json 데이터는 아래와 같이 생겼음
        //향후 Vue에서 보내는 데이터도 전부 이 json형태로 날아옴
        //우리가 SRT API나 여러가지 Rest API라고 하는 녀석들도
        //요청을하면 데이터 형식이 전부 json형식으로 날아옴
        String jsonString = "{\"title\" : \"hihi\" ,"+
          "\"draft\" : false, "+
            "\"star\":5"+
                "}";

        //Json 파싱
        JSONObject jObj = new JSONObject(jsonString);
        String title = jObj.getString("title");
        Boolean draft = jObj.getBoolean("draft");
        Integer star = jObj.getInt("star");

        log.info("title: "+ title + ", draft: "+ draft + ", star: "+ star);


        return jsonString;
    }

    @GetMapping("/jsonMultiObjectTest")
    public String getjsonMultiObjectTest(){
        String jsonString = "{" +
                "\"movie1\":{" +
                    "\"title\" : \"hihi\" ,"+
                    "\"draft\" : false, "+
                    "\"star\":5" +
                "}, " +
                "\"movie2\":{" +
                    "\"title\" : \"code monkey\" ,"+
                    "\"draft\" : false, "+
                    "\"star\":5"+
                    "}" +
                "}" ;

        //json 내에 Object형식이 구성된 경우의 파싱
        JSONObject jObj = new JSONObject(jsonString);
        JSONObject movie10bj = jObj.getJSONObject("movie1");
        log.info("movie1:" +movie10bj.toString()+
                "\ntitle: "+movie10bj.getString("title")+
                ", draft: "+movie10bj.getBoolean("draft")+
                ", star: "+movie10bj.getInt("star")
        );

        JSONObject movie20bj = jObj.getJSONObject("movie2");
        log.info("movie2:" +movie20bj.toString()+
                "\ntitle: "+movie20bj.getString("title")+
                ", draft: "+movie20bj.getBoolean("draft")+
                ", star: "+movie20bj.getInt("star")
        );

        return jsonString;
    }

    //현재시점까지의 json처리는
    //향후 Vue에서 AXIOS라는것을 사용하며 모두 처리가 될 것임
    //한가지 차이가 있다면 나중에 python과 연동할때
    //Spring의 Request를 통해서
    //Spring 자체가 Client가 되어 Python Server에 요청을 넣어야함
    //그 시점에서는 Spring이 직접 Json

    @GetMapping("/jsonArrayTest")
    public String getjsonPowerTest() {
        String jsonString = "{" +
                "\"movies\":[" +
                "{"+
                    "\"title\" : \"hihi\" ," +
                    "\"draft\" : false, " +
                    "\"star\":5" +
                "}, " +
                "{" +
                    "\"title\" : \"code monkey\" ," +
                    "\"draft\" : false, " +
                    "\"star\":4.7" +
                "}" +
            "]"+
        "}"
                ;

        //JSON배열 파싱
        JSONObject jObj = new JSONObject(jsonString);
        JSONArray jArr = jObj.getJSONArray("movies");

        //
        for (int i =0;i<jArr.length();i++){
            JSONObject obj = jArr.getJSONObject(i);

            String title = obj.getString("title");
            Boolean draft = obj.getBoolean("draft");
            Float star = obj.getFloat("star");

            log.info("title: " +title+", draft: "+draft+", star: "+star);
        }
        return jsonString;
    }

}
