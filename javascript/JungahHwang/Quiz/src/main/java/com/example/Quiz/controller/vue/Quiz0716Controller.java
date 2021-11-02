package com.example.Quiz.controller.vue;

import com.example.Quiz.entity.Product;
import com.example.Quiz.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/vueproduct")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Quiz0716Controller {

    @Autowired
    private ProductService service;

    @PostMapping("/register")
    public ResponseEntity<Product> register(@Validated @RequestBody Product product) throws Exception {
        log.info("success");

        service.register(product);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Product>> getLists() throws Exception {
        log.info("getLists()");

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{productNo}")
    public ResponseEntity<Product> read(@PathVariable("productNo") Integer productNo) throws Exception {
        Product product = service.read(productNo);

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PutMapping("/{productNo}")
    public ResponseEntity<Product> modify(@PathVariable("productNo") Integer productNo,
                                          @Validated @RequestBody Product product) throws Exception {
        log.info("수정!");
        product.setProductNo(productNo);

        service.modify(product);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{productNo}")
    public ResponseEntity<Void> remove(@PathVariable("productNo") Integer productNo) throws Exception {
        service.remove(productNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}


































