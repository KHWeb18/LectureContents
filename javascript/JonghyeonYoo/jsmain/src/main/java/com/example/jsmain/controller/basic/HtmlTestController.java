package com.example.jsmain.controller.basic;

import com.example.jsmain.utility.Test;
import com.example.jsmain.utility.network.Client;
import com.example.jsmain.utility.network.Server;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller

public class HtmlTestController {

    @GetMapping("/")
    public String firstIndex() {
        log.info("firstIndex()실행");
        return "htmlHi";
    }

    @GetMapping("/fail")
    public String doFail() {
        log.info("doFail()");
        return "fail";
    }

    @GetMapping("/comparatorTest")
    public String comparatorTest() {
        log.info("comparatorTest()");

        Test test = new Test();
        test.doTest();

        return "test";
    }

    @GetMapping("/serverOn")
    public String startServer() {
        log.info("startServer()");

        Server server = new Server();
        server.waitForClientTest();

        return "test";
    }

    @GetMapping("/clientOn")
    public String startClient() {
        log.info("startClient()");

        Client client = new Client();
        client.connectToServerTest();

        return "test";
    }
}
