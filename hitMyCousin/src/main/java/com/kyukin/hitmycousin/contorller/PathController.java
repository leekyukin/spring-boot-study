package com.kyukin.hitmycousin.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PathController {

    @GetMapping("/login")
    public void Glogin() {}

    @PostMapping("/")
    public String loginToHome() {
        return "home";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }
}
