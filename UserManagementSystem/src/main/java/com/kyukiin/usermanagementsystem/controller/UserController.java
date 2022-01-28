package com.kyukiin.usermanagementsystem.controller;

import com.kyukiin.usermanagementsystem.dto.JoinUser;
import com.kyukiin.usermanagementsystem.dto.LoginDto;
import com.kyukiin.usermanagementsystem.entity.User;
import com.kyukiin.usermanagementsystem.enums.StatusCode;
import com.kyukiin.usermanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/MShow")
    public List<User> getAllUserInManagerAccount() {
        return userService.MgetAll();
    }

    @GetMapping("/show/{status}")
    public List<User> getStatusUser(
            @PathVariable StatusCode status
            ) {
        return userService.getStatusUser(status);
    }

    @PostMapping("/login")
    public LoginDto.Response login(
            @Valid @RequestBody LoginDto.Request request
    ) {
        log.info("=======login========" + request);

        return userService.login(request);
    }

}
