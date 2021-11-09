package com.example.SoloProject.controller;

import com.example.SoloProject.entity.Board;
import com.example.SoloProject.entity.Product;
import com.example.SoloProject.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/register")
    public String getProduct (Product product, Model model) throws Exception {
        log.info("getProduct(): " + service.lists());

        model.addAttribute("lists", service.lists());

        return "/product/register";
    }

    @PostMapping("/register")
    public String postProduct (Product product, Model model) throws Exception {
        log.info("postProduct()");
        log.info("Product: " + product);

        service.register(product);

        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/product/success";
    }

    @GetMapping("/lists")
    public String getList (Model model) throws Exception {
        log.info("getList(): " + service.lists());

        model.addAttribute("product", service.lists());

        return "/product/lists";
    }

    @GetMapping("/read")
    public String getRead (int productNo, Model model) throws Exception{
        log.info("read(): productNo = " + productNo);

        model.addAttribute(service.read(productNo));

        return "/product/read";
    }

    @GetMapping("/modify")
    public String getModify(int productNo, Model model) throws Exception{
        log.info("getmodify()");

        model.addAttribute(service.read(productNo));

        return "/product/modify";
    }

    @PostMapping("/modify")
    public String postModify (Product product, Model model) throws Exception{
        log.info("postModify()");

        service.modify(product);
        model.addAttribute("msg", "수정이 성공적으로 완료되었습니다");

        return  "/product/success";
    }

    @PostMapping("/remove")
    public String remove (int productNo, Model model) throws Exception{
        log.info("remove()");

        service.remove(productNo);

        model.addAttribute("msg", "삭제가 완료되었습니다");

        return "/product/success";
    }
}
