package com.kyukiin.getinline.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller   // implements BasicErrorController 하지 않는다면 기본 에러페이지가 작동된다.
              // BasicErrorController 를 상속하면 에러페이지 개발자가 커스텀 가능하다.
public class BaseController  {
    @GetMapping("/")
    public String root() {
       return "index";
    }

}
