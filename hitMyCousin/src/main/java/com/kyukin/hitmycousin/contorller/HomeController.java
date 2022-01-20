package com.kyukin.hitmycousin.contorller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {


    @PostMapping("/")
    public String h() {
        return "home";
    }

    @GetMapping("/login")
    public String login1() {
        return "login";
    }

    @PostMapping("/login")
    public void login2() {}

    @GetMapping("/join")
    public String join() {
        return "join";
    }



}
