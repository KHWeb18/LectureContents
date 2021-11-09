package com.example.demo.controller.springtest;


import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/http-method")
public class HttpMethodController {
    @Autowired
    private BoardService service;

    @GetMapping("/modify")
    public String getModifyBoard (int boardNo, Model model) throws Exception {
        log.info("getModifyBoard()");

        // 수정을 눌렀을때 기존 정보를 가져와야함
        model.addAttribute(service.read(boardNo));

        return "/board/eighth/modify";
    }

    @PostMapping("/modify")
    public String postModifyBoard (Board board, Model model) throws Exception {
        log.info("postModifyBoard(): " + board);

        service.modify(board);
        model.addAttribute("msg", "수정이 성공적으로 완료되었습니다!");

        return "/board/fourth/success";
    }
    @GetMapping("/lists")
    public String getListsBoard (Model model) throws Exception {
        log.info("getlistsBoard()");

        model.addAttribute("lists",service.list());

        return "/board/fifth/lists";
    }

    // thymeleaf에서는 아래와 같이 특정한 객체를 입력으로 받으면
    // HTML에서 th:object와 같은 키워드를 통해 정보를 획득할 수 있다.
    // 즉 board 객체의 정보를 획득할 수 있음을 의미한다.
    @GetMapping("/register")
    public String getRegisterBoard (Board board, Model model) {
        log.info("getRegisterBoard()");

        return "/board/fourth/register";
    }

    // MVC(Model View Controller) Pattern
    // Model: 다루는 데이터
    // View: 눈에 보이는 화면
    // Controller: URL 제어
    @PostMapping("/register")
    public String postRegisterBoard (Board board, Model model) throws Exception {
        log.info("postRegisterBoard()");
        log.info("Board: " + board);

        service.register(board);

        // msg 라는 속성값에 "등록이 완료되었습니다!"을 맵핑함
        // key: msg, value: "등록이 완료되었습니다!" 라고 생각하면 편함
        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/board/fourth/success";
    }
    @GetMapping("/read/{boardNo}")
    public String getReadBoard(@PathVariable("boardNo")int boardNo , Model model) throws Exception {
        log.info("readBoardBoard" + boardNo);

        model.addAttribute(service.read(boardNo));

        return "board/seventh/read";

    }
    @PostMapping("/remove")
    public String removeBoard (int boardNo, Model model) throws  Exception{
        log.info("removeBoard");

        service.remove(boardNo);

        model.addAttribute("msg","삭제가 완료되었습니다");

        return "board/fourth/success";
    }
    @GetMapping("/jsonTest")
    public String getJsonTest () {

        return "I'm JSON!!!!";
    }

    @GetMapping("/jsonKeyValueTest")
    public String getJsonKeyValueTest () {
        String jsonString = "{\"title\": \"hihi\", " +
                "\"draft\": false, " +
                "\"star\": 5" +
                "}";

        // JSON 파싱
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

        log.info("movie1" + movie1Obj.toString() +
                "\ntitle:" + movie1Obj.getString("title") +
                ", draft: " + movie1Obj.getBoolean("draft") +
                ", star: " + movie1Obj.getInt("star"));

        JSONObject movie2Obj = jObj.getJSONObject("movie2");

        log.info("movie2" + movie2Obj.toString() +
                "\ntitle:" + movie2Obj.getString("title") +
                ", draft: " + movie2Obj.getBoolean("draft") +
                ", star: " + movie2Obj.getInt("star"));


        return jsonString;
    }

    //현재 시점까지의 json처리는 향후 Vue에서 AXIOS라는 것을 사용하며 모두처리가될것임
    //한가지 차이가 있다면 나중에 python과 연동할 때
    //Spring의 Requester을 통해서 Spring 자체가 Client가 되어야함
    //그 시점에서는 Spring이 직접 JSON을 처리할 필요가 있음
    //Python Server에 요청을 넣어
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

        // JSON 배열 파싱
        JSONObject jObj = new JSONObject(jsonString);
        JSONArray jArr = jObj.getJSONArray("movies");

        // 루프를 돌며 JSON 배열의 모든 정보를 출력함
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
