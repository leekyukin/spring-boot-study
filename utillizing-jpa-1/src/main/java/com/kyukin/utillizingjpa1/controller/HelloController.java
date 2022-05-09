package com.kyukin.utillizingjpa1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HelloController {

    @GetMapping("/")
    public String main() {
        return "main.html";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "이규진");

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }
        model.addAttribute("list", list);
        return "hello";
    }

}
