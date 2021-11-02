package com.example.demo.controller.board;

import com.example.demo.entity.Member;
import com.example.demo.entity.Product;
import com.example.demo.service.BoardService;
import com.example.demo.service.ProductService;
import com.example.demo.service.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class FifthController {   //게시글 목록, 회원가입 상품페이지 연습한 컨트롤러

    @Autowired
    private BoardService service;

    @GetMapping("/lists")
    public String getLists (Model model) throws Exception {
        log.info("getLists(): " + service.list());

        model.addAttribute("lists", service.list());

        return "/board/fifth/lists/lists";
    }

    //
    @Autowired
    private SignUpService signupservice;

    @GetMapping("/signup")
    public String getSignUp (Member member, Model model) {
        log.info("getSignUp()");

        return "/board/fifth/member/signup";
    }

    @PostMapping("/signup")
    public String postSignUp (Member member, Model model) {
        log.info("postSignUp(): " + member);

        signupservice.signup(member);

        model.addAttribute("msg", "가입이 완료되었습니다!");

        return "/board/fifth/member/success";
    }

    @Autowired
    private ProductService productservice;

    @GetMapping("/productregister")
    public String getProduct (Product product, Model model) throws Exception {
        log.info("getProduct(): " + productservice.productlist());

        model.addAttribute("productlists", productservice.productlist());

        return "/board/fifth/product/productregister";
    }

    @PostMapping("/productregister")
    public String postProduct (Product product, Model model) throws Exception {
        log.info("postProduct()");
        log.info("Product: " + product);

        productservice.productregister(product);

        model.addAttribute("pdt", "등록이 완료되었습니다!");

        return "/board/fifth/product/success";
    }

    @GetMapping("/productlist")
    public String getProductlist (Model model) throws Exception {
        log.info("getProductlist(): " + productservice.productlist());

        model.addAttribute("product", productservice.productlist());

        return "/board/fifth/product/productlist";
    }
}