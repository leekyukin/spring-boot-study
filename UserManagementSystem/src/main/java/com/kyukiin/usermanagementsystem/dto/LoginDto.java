package com.kyukiin.usermanagementsystem.dto;

import com.kyukiin.usermanagementsystem.entity.User;
import com.kyukiin.usermanagementsystem.enums.UserDepartment;
import com.kyukiin.usermanagementsystem.enums.UserSkillType;
import com.kyukiin.usermanagementsystem.enums.LoginCode;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class LoginDto {


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {

        @NotNull
        @Size(min = 13, max = 20, message="Email size must 13 ~ 20")
        private String email;

        @NotNull
        @Size(min = 8, max = 16, message="Pw size must 8 ~ 16")
        private String pw;
    }


    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {

        private UserDepartment userDepartment;
        private UserSkillType userSkillType;
        private Integer grade;
        private String nickName;

        private LoginCode loginCode;

        public static Response fromEntity(User user, LoginCode loginCode) {

            Response response = Response.builder()
                    .loginCode(loginCode)
                    .grade(user.getGrade())
                    .nickName(user.getNickName())
                    .userDepartment(user.getUserDepartment())
                    .userSkillType(user.getUserSkillType())
                    .build();
            return response;
        }
    }

}
