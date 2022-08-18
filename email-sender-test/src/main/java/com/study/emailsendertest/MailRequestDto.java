package com.study.emailsendertest;

import lombok.Getter;

@Getter
public class MailRequestDto {
    private String receiver;
    private String title;
    private String content;
}
