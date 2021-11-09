package com.example.demo.basic;

import com.example.demo.utility.Test;
import com.example.demo.utility.network.Client;
import com.example.demo.utility.network.Server;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HtmlTestController {
    // HtmlTestController가 제어하는 요소를 디버깅하도록 서포트하는 객체
    // static final Logger log = LoggerFactory.getLogger(HtmlTestController.class);

    //실제 웹상에서 URL 요청할 때는 자주 사용하는 두 가지 방식이있다.
    //Get, Post 방식인데 우선 일반적인 URL 입력은 Get으로 파악하면 되겠다.
    // 현재 우리의 ip의
    @GetMapping("/") //메인 페이지를 맵핑한다.
    public String firstIndex () {
        // 위에 Logger 사용하는 방식은 Lombok이 없을 경우 사용함
        // 그래서 이클립스에서는 상당히 불편하게 구성해야하는데 비해
        // 여기서는 맨 위쪽의 @Slf4j 를 추가함으로써
        // 위의 Logger 파트를 적어줄 필요가 없어짐
        log.info("firstIndex() 실행");

        return "htmlHi";
    }

    @GetMapping("/comparatorTest")
    public String comparatorTest () {
        log.info("comparatorTest()");

        Test test = new Test();
        test.doTest();

        return "test";
    }
    @GetMapping("/fail")
    public String fail () {
        log.info("fail()");

        return "fail";
    }


    @GetMapping("/serverOn")
    public String startServer() {

        log.info("startServer()");

        Server server = new Server();
        server.waitForClientTest();

        return "test";
    }

    @GetMapping("/clientOn")
    public String startClient () {
        log.info("startClient()");

        Client client = new Client();
        client.connectToServerTest();

        return "test";
    }
}
