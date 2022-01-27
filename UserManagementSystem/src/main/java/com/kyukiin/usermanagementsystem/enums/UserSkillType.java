package com.kyukiin.usermanagementsystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserSkillType {

    BACK_END("백앤드 개발자"),
    FRONT_END("프론트앤드 개발자"),
    FULL_STACK("풀스택 개발자"),
    MICRO_PROCESSOR("마이크로 프로세서 개발자"),
    FIRM_WARE("펌웨어 개발자")
    ;

    private final String description;

}
