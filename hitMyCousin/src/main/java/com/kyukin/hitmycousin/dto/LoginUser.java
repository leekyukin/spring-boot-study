package com.kyukin.hitmycousin.dto;


import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

public class LoginUser {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {

        @NotNull
        private String name;
        @NotNull
        private String id;
        @NotNull
        private String pw;
        private Long hit;


    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {

        @NotNull
        private String name;
        private Long hit;
    }

}
