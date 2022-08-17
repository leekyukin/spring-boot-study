package com.study.redisTest.dto;

import lombok.Getter;

@Getter
public class UpdateRequestDto {
    private String key;
    private String newKey;
}
