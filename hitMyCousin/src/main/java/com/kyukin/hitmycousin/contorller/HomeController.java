package com.kyukin.hitmycousin.contorller;


import com.kyukin.hitmycousin.dto.LoginUser;
import com.kyukin.hitmycousin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @PostMapping("/login")
    public void joinToLogin(LoginUser.Request request) {
        userService.join(request);
    }






}
