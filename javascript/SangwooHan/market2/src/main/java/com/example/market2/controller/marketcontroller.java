package com.example.market2.controller;

import com.example.market2.entity.Login;
import com.example.market2.entity.Market;
import com.example.market2.entity.Signup;
import com.example.market2.service.marketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Slf4j
@Controller
class marketcontroller {


    @Autowired
    private marketService service;
    @GetMapping("/register")
    public String getRegister (Market market, Model model) throws Exception{
        log.info("getRegister()");

        return "/market/register";
    }

    @PostMapping("/register")
    public String postRegister (Market market, Model model) throws Exception {

        log.info("postRegister()");

        log.info("market:" + market);


        service.register(market);

        return "/market/success";
    }



    @GetMapping("/lists")
    public String getlist (Model model) throws Exception{
        log.info("getList():"+service.list());


            model.addAttribute("market",service.list());


        return "/Market/lists";
    }
    @GetMapping("/homepage")
    public String gethomepage (){
        log.info("gethomepage()");
        return "/Market/homepage";
    }



    @GetMapping("/signupcomplete")
    public  String signupcomplete(){
        log.info("signupcomplete()");

        return "/Market/signupcomplete";
    }

    @GetMapping("/MarketPage")
    public  String MarketPage(){
        log.info("MarketPage()");

        return "/Market/MarketPage";
    }
@GetMapping("/read")
    public String getRead(int productNo, Model model) throws  Exception{
        log.info("read");

        model.addAttribute(service.read(productNo));

        return "/Market/read";
}
    @PostMapping("/remove")
    public  String remove(int productNo, Model model) throws  Exception{
        log.info("remove()");
        service.remove(productNo);
        model.addAttribute("msg","??????????????????????????????.");

        return "/market/success";
    }
    //???????????? ??????????????? ??????????????? ????????? read??? ?????? ??????????????? ????????????.
    @GetMapping("/modify")
public String getModify(int productNo, Model model)throws  Exception{
        log.info("getModify()");

        model.addAttribute(service.read(productNo));
        //???????????? ??????????????? ??????????????? ????????? read??? ?????? ??????????????? ????????????.
        return "/market/modify";

    }
    @PostMapping("/modify")
    public  String postModify(Market market , Model model) throws  Exception{
        log.info("postModify()");


        service.modify(market);
        model.addAttribute("msg","????????? ?????????????????????.");
        return "/market/success";
    }
    @GetMapping("/signup")
    public  String getsignup (Signup signup, Model model) throws  Exception{
        log.info("getSignup()");

        return "/Market/signup";
    }
    @PostMapping("/signup")
    public  String postsignup (Signup signup, Model model) throws  Exception{
        log.info("postSignup");

        service.signup(signup);
        model.addAttribute("msg","??????????????? ???????????????.");

        return "/Market/success";
    }
    @GetMapping("/nagnetshoppingmall")
    public String getnagnetshoppingmall () throws Exception{
        log.info("genagnetshoppingmall()");

        return "/market/nagnetshoppingmall";
    }
    @GetMapping("/login")
    public  String getLogin (Login login , Model model,Signup signup) throws  Exception{
        log.info("getLogin");


        return "/market/login";
    }
    @PostMapping("/login")
    public String postLogin(Login login, Model model, Signup signup, HttpServletResponse response, HttpServletRequest request) throws  Exception {
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");


        log.info("postLogin()");
        int num = service.login(login);
        System.out.println("???????????? = " +num);
        if(num == 1){

            num = 0;
            return "/market/success";
        }else{
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            String htmlResponse = "<script>alert('login fail'); location.href='/login';</script>";
            out.println(htmlResponse);
            out.close();
        }


        //   service.logincheck(login,signup);
        // if(service.logincheck(login,signup)==true){

        // model.addAttribute("msg","???????????? ??????????????? ???????????????.");
        // return "/market/success";
        // }else{
        //     model.addAttribute("msg","????????????????????????????????? ???????????????????????????");
        //    return "/market/success";

        // }
    return "/market/success";
    }





}
