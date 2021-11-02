package com.example.market3.Controller1;

import com.example.market3.Entity.Market;
import com.example.market3.Entity.Signup;
import com.example.market3.Service.marketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
class marketcontroller {


    @Autowired
    private marketService service;
    @GetMapping("/register")
    public String getRegister (Market market, Model model) throws Exception{
        log.info("getRegister()");

        return "/board/boardRegister";
    }

    @PostMapping("/register")
    public String postRegister (Market market, Model model) throws Exception {

        log.info("postRegister()");

        log.info("market:" + market);


        service.register(market);

        return "/success";
    }

    @GetMapping("/lists")
    public String getlist (Model model) throws Exception{
        log.info("getList():"+service.list());


            model.addAttribute("market",service.list());


        return "/board/boardLists";
    }
    @GetMapping("/homepage")
    public String gethomepage (){
        log.info("gethomepage()");
        return "/Homepage/homepage";
    }



    @GetMapping("/signupcomplete")
    public  String signupcomplete(){
        log.info("signupcomplete()");

        return "/Market/signupcomplete";
    }


@GetMapping("/read")
    public String getRead(int productNo, Model model) throws  Exception{
        log.info("read");

        model.addAttribute(service.read(productNo));

        return "/board/boardRead";
}
@GetMapping("/read2")
    public String getRead2(int bulletinNo, Model model) throws  Exception{
        log.info("getRead2");

       model.addAttribute(service.memberRead(bulletinNo));

        return "/Manager/memberRead";
}
    @PostMapping("/remove")
    public  String remove(int productNo, Model model) throws  Exception{
        log.info("remove()");
        service.remove(productNo);
        model.addAttribute("msg","삭제가완료되었습니다.");

        return "/success";

    }
        @PostMapping("/memberRemove")
        public String memberRemove(int bulletinNo ,Model model)throws Exception{
        log.info("memberRemove()");
        service.memberRemove(bulletinNo);
        model.addAttribute("msg","회원이 정상적으로탈퇴되었습니다.");
        return "/success";
        }
    //수정할때 기존정보를 가져와야함 그래서 read를 하여 해당정보를 가져왔음.
    @GetMapping("/modify")
public String getModify(int productNo, Model model)throws  Exception{
        log.info("getModify()");

        model.addAttribute(service.read(productNo));

        //수정할때 기존정보를 가져와야함 그래서 read를 하여 해당정보를 가져왔음.
        return "/board/boardModify";

    }
    @PostMapping("/modify")
    public  String postModify(Market market , Model model) throws  Exception{
        log.info("postModify()");


        service.modify(market);
        model.addAttribute("msg","수정이 완료되었습니다.");
        return "/success";
    }
    @GetMapping("/signup")
    public  String getsignup (Signup signup, Model model) throws  Exception{
        log.info("getSignup()");

        return "/Signup/signup";
    }
    @PostMapping("/signup")
    public  String postsignup (Signup signup, Model model) throws  Exception{
        log.info("postSignup");

        service.signup(signup);
        model.addAttribute("msg","회원가입을 축하합니다.");

        return "/Signup/signupcomplete";
    }
    @GetMapping("/nagnetshoppingmall")
    public String getnagnetshoppingmall () throws Exception{
        log.info("genagnetshoppingmall()");

        return "/market/nagnetshoppingmall";
    }


    @GetMapping("/fail")
    public  String getFail(){
        log.info("getFail()");

        return "/market/fail";
    }
    @GetMapping("/loginpage")
    public  String getloginpage(Signup signup, Model model) throws  Exception{
        log.info("getloginpage");

        return  "/Login/loginpage";

    }
    @PostMapping("/loginpage")
    public  String postloginpage(Signup signup, Model model)throws  Exception{
        log.info("postloginpage()");
           service.login(signup);

        model.addAttribute("msg", "로그인성공");
        return "/success";
    }
    @GetMapping("/memberList")
    public String memberList (Model model) throws Exception{
        log.info("memberList():"+service.memberList());


        model.addAttribute("signup",service.memberList());


        return "/Manager/memberList";
    }
@GetMapping("/Reservation")
    public String getReservation(){
        log.info("getReservation()");

        return "/market/reservation";
}

@PostMapping("/memberModify")
    public String postmemberModify(Signup signup, Model model) throws Exception {
        log.info("memberModify()");
    service.memberModify(signup);
    model.addAttribute("msg","수정이 완료되었습니다.");

        return "/success";
}
@GetMapping("/memberModify")
    public String getmemberModify(int bulletinNo, Model model )throws Exception{
        log.info("getmemberModify()");
    model.addAttribute(service.memberRead(bulletinNo));
        return "/Manager/memberModify";
}

@GetMapping ("/noticePage")
    public  String getNoticePage(){
        log.info("getNoticePage");

        return "/Notice/NoticeRegister";
}


}
