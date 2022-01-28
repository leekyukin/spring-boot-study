package com.kyukiin.usermanagementsystem.dto;

import com.kyukiin.usermanagementsystem.entity.User;
import com.kyukiin.usermanagementsystem.enums.UserDepartment;
import com.kyukiin.usermanagementsystem.enums.UserSkillType;
import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class JoinUser {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {

        @NotNull
        private UserDepartment userDepartment;
        @NotNull
        private UserSkillType userSkillType;
        @NotNull
        @Min(1)
        @Max(3)
        private Integer grade;

        @NotNull
        @Size(min = 3, max = 16, message = "NickName size must 3 ~ 16")
        private String nickName;

        @NotNull
        @Size(min = 13, max = 20, message = "Uid size must 16 ~ 20")
        private String email;

        @NotNull
        @Size(min = 8, max = 16, message = "pw size must 8 ~ 16")
        private String pw;

        @NotNull
        @Min(16)
        @Max(20)
        private Integer age;

        @NotNull
        @Size(min = 0, max = 100, message = "Introduction size must 0 ~ 100")
        private String introduction;

        @NotNull
        private String name;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private UserDepartment userDepartment;
        private UserSkillType userSkillType;
        private Integer grade;
        private String nickName;
        private String email;
        private String introduction;

        public static Response fromEntity(User user) {
            return Response.builder()
                    .userDepartment(user.getUserDepartment())
                    .userSkillType(user.getUserSkillType())
                    .grade(user.getGrade())
                    .nickName(user.getNickName())
                    .introduction(user.getIntroduction())
                    .email(user.getEmail())
                    .build();
        }
    }
}
