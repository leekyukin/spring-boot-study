package com.practice.jparelationshippractice.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/localhost/users")
    public createUserResponse saveMemeberV2(@RequestBody @Validated )
}
