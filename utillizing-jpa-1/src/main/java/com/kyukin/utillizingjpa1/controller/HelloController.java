package com.kyukin.utillizingjpa1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String main() {
        return "main.html";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "이규진");
        return "hello";
    }
}
