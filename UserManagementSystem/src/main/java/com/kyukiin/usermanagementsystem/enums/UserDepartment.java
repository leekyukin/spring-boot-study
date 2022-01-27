package com.kyukiin.usermanagementsystem.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserDepartment {

    UNDEFINED("미정"),
    SOFTWARE_DEVELOPMENT("소프트웨어 개발과"),
    EMBEDDED_DEVELOPMENT("임베디드 개발과");

    private final String description;

}
