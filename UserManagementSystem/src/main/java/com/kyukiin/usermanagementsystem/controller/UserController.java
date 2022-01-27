package com.kyukiin.usermanagementsystem.controller;

import com.kyukiin.usermanagementsystem.dto.JoinUser;
import com.kyukiin.usermanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.Join;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@ToString
public class UserController {

    private final UserService userService;


    @PostMapping("/join")
    public JoinUser.Response joinUser(
        @Valid @RequestBody JoinUser.Request request
    ) {
        log.info("----joinUser!!!!!" + request);
        return userService.joinUser(request);
    }

}
