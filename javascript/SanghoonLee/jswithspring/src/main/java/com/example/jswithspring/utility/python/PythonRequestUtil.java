package com.example.jswithspring.utility.python;

import com.example.jswithspring.controller.hybrid.request.RequestHybridOrder;
import org.springframework.web.client.RestTemplate;

public class PythonRequestUtil {

    public String orderTest(RequestHybridOrder order) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(
                "http://localhost:5000/spring2pythonRequestWithData",
                order,
                String.class
        );
    }

    public String getKakaoAuth() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(
                "http://localhost:5000/getKakaoAuth",
                String.class
        );
    }
}
