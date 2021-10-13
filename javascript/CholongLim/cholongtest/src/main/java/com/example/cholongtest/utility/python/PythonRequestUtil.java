package com.example.cholongtest.utility.python;

import com.example.cholongtest.controller.hybrid.request.RequestHybridOrder;
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
}
