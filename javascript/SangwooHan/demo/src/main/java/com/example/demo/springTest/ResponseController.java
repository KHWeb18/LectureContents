package com.example.demo.springTest;

import com.example.demo.entity.NagetloningTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ResponseController {


    @GetMapping("/jsonMember")
    public NagetloningTest jsomMember (){
         log.info("jsonMember");


        NagetloningTest nagetloningTest = new NagetloningTest();
        nagetloningTest.setId("name");
        nagetloningTest.setPw("test");

        return nagetloningTest;

    }

    @GetMapping("/jsonListMember")
    public List<NagetloningTest> jsonListMember(){

        List<NagetloningTest> list = new ArrayList<NagetloningTest>();

        NagetloningTest nagetloningTest1 = new NagetloningTest();

        nagetloningTest1.setId("name1");
        nagetloningTest1.setPw("test1");
        list.add(nagetloningTest1);

        NagetloningTest nagetloningTest2 = new NagetloningTest();

        nagetloningTest2.setId("name");
        nagetloningTest2.setPw("test1");
        list.add(nagetloningTest2);

        return list;
    }

    @GetMapping("/jsonHashMapMember")
    public Map<String, NagetloningTest> jsonHashMapMember(){

       Map<String ,NagetloningTest> map = new HashMap<String, NagetloningTest>();

        NagetloningTest nagetloningTest1 = new NagetloningTest();

        nagetloningTest1.setId("name");
        nagetloningTest1.setPw("test");
       map.put("key1",nagetloningTest1 );

        NagetloningTest nagetloningTest2 = new NagetloningTest();

        nagetloningTest2.setId("name");
        nagetloningTest2.setPw("test");
        map.put("key2", nagetloningTest2);

        return map;
    }


    @GetMapping("/jsonvoid")
    public ResponseEntity<Void> jsonVoid(){
        log.info("jsonVoid()");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/jsonString")
    public  ResponseEntity<String> jsonString(){
        log.info("jsonString");

        return new  ResponseEntity<String>("success", HttpStatus.OK);
    }
}
