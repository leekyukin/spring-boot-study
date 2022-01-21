package com.kyukin.hitmycousin.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum UserErrorCode {

    DUPLICATE_ID("id가 중복됍니다."),
    SORT_PW("정책에 맞지 않는 pw");

    private final String message;


}
