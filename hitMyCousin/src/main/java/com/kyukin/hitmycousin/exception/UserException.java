package com.kyukin.hitmycousin.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserException extends RuntimeException {

    private UserErrorCode userExceptionCode;
    private String detailMessage;

    public UserException(UserErrorCode errorCode) {
        super(errorCode.getMessage());
        this.detailMessage = errorCode.getMessage();
        this.userExceptionCode = errorCode;
    }
}
