package com.kyujin.annotationtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

//  @PathVariable : URI 경로의 일부를 파라미터로 사용할 때 이용(URI 경로에서 값을 가져온다)
    @GetMapping("/{name}")
    @ResponseBody
    public String testPathVariable(@PathVariable String name) {
        return name;
    }
}
