package com.example.cholongtest.controller.python;

import com.example.cholongtest.entity.python.Product;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


// Controller와 RestController의 차이점은 ?
// Controller
// url 처리 : return "hello" -> hello.html로 자동 처리
// RestController
// 데이터 처리에 더 유용하다.

@Slf4j
@RestController
public class PythonRequestTestController {

    // spring 에서 python 요청
    @GetMapping("/spring2pythonRequest")
    public ModelAndView doRequestPythonRest(Model model) {
        log.info("doRequestPythonRest():");

        // 2. 파이썬에 request
        List<HttpMessageConverter<?>> converters =
                new ArrayList<HttpMessageConverter<?>>();

        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        // 3. 작업 시 세팅, url에 따라 res값이 달라진다.
        String result = restTemplate.getForObject(
                // 프로젝트 진행시에는 이 부분만 바꿔가면서 사용하게 될 것임
                "http://localhost:5000/spring2pythonRequest",
                String.class
        );

        log.info("result = " + result);
        /*
            부가적으로 이 중간 부분에 추가적인 가공이 필요하다면
            처리된 결과인 result를 이 부분에서 가공하여 아래 html에서 처리를 하거나
            혹은 Vue로 보내서 출력하는 형식을 취해도 무방하다.
         */

        // 1. url 처리
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("python/pyResult");

        model.addAttribute("resultMsg", result);

        return modelAndView;
    }

    @GetMapping("/spring2pythonRequestMulti")
    public ModelAndView doRequestPythonRestMulti(Model model) {
        log.info("doRequestPythonRestMulti():");

        List<HttpMessageConverter<?>> converters =
                new ArrayList<HttpMessageConverter<?>>();

        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        String result = restTemplate.getForObject(

                "http://localhost:5000/spring2pythonRequestMulti",
                String.class
        );

        log.info("result = " + result);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("python/pyResult");

        model.addAttribute("resultMsg", result);

        return modelAndView;
    }

    // 스프링이 가지고 있는 정보를 어떻게 파이썬에게 전달할 것인가
    @GetMapping("/spring2pythonRequestWithData")
    public ModelAndView doRequestPythonRestWithData(Model model) {
        log.info("doRequestPythonRestWithData()");

        RestTemplate restTemplate = new RestTemplate();

        // Entity 자체를 객체화 한다
        Product product = new Product(35000);

        // 무조건 Entity 형식의 객체를 전송하도록 한다
        String result = restTemplate.postForObject(
                "http://localhost:5000/spring2pythonRequestWithData",
                product,
                String.class
        );

        log.info("result = " + result);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("python/pyResult");

        model.addAttribute("resultMsg", result);

        return modelAndView;
    }
}
