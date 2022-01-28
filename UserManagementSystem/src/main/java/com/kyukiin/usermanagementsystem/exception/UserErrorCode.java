package com.kyukiin.usermanagementsystem.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserErrorCode {

    NO_USER("해당되는 학생이 없습니다."),
    DUPLICATED_USER_EMAIL("이미 존재하는 이메일입니다."),
    DEPARTMENT_GRADE_NOT_MATCHED("1학년은 학과가 정해지지 않았습니다."),
    DUPLICATE_USER_NICKNAME("이미 존재하는 닉네임입니다."),

    INTERNAL_SERVER_ERROR("서버에 오류가 발생했습니다."),
    INVALID_REQUEST("잘못된 요청입니다.")
    ;

    private final String message;
}
