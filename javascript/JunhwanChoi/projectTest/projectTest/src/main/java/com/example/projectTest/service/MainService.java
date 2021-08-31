package com.example.projectTest.service;

import java.net.URI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.example.projectTest.vo.Response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MainService {

    @Value("${openapi.service.key}")
    String OPENAPI_KEY;

    @Value("${openapi.service.url}")
    String OPENAPI_URL;

    public ResponseEntity<String> getAPi(){
        String url = OPENAPI_URL + "?serviceKey=" + OPENAPI_KEY;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(URI.create(url), HttpMethod.GET, entity, String.class);

        return response;
    }

    public Response parser(String xml) {
        ObjectMapper xmlMapper = new XmlMapper();
        Response response = null;
        try {
            response = xmlMapper.readValue(xml, Response.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return response;
    }
}