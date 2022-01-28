package com.kyukiin.usermanagementsystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoginCode {

    FAIL("로그인 실패"),
    NO_EMAIL("이메일이 존재하지 않습니다."),
    SUCCESS("로그인 성공")
    ;

    private final String description;

}
