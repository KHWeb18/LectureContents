package com.example.demo.controller.basic;

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

    // 실제 웹상에서 URL 요청할 때는 자주 사용하는 두 가지 방식이 있다.
    // Get, Post 방식인데 우선 일반적인 URL 입력은 Get으로 파악하면 되겠다.
    // 현재 우리의 ip:port 주소의 Home을 의미한다.

    // Controller가 사용자의 'ip:port/' 형식의 요청을 하였을때 동작할 내용 정의
    @GetMapping("/")
    public String firstIndex () {
        // 위에 Logger 사용하는 방식은 Lombok이 없을 경우 사용함
        // 그래서 이클립스에서는 상당히 불편하게 구성해야하는데 비해
        // 여기서는 맨 위쪽의 @Slf4j 를 추가함으로써
        // 위의 Logger 파트를 적어줄 필요가 없어짐
        log.info("firstIndex() 실행");

        // 여기서 리턴되는 String 값은 resources/templates/htmlHi.html을 의미함
        // 즉 이 부분에 무엇을 배치하냐에 따라 출력되는 내용이 제각각 달라짐을 의미!
        return "htmlHi";
    }

    @GetMapping("/fail")
    public String doFail () {
        log.info("doFail()");

        return "fail";
    }

    @GetMapping("/comparatorTest")
    public String comparatorTest () {
        log.info("comparatorTest()");

        Test test = new Test();
        test.doTest();

        return "test";
    }

    @GetMapping("/serverOn")
    public String startServer () {
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