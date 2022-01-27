package com.kyukiin.usermanagementsystem.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {

    EXISTING("존재하는 회원"),
    REMOVED("탈퇴한 회원");

    private final String description;
}
