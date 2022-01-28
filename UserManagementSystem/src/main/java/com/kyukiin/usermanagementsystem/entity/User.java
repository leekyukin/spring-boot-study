package com.kyukiin.usermanagementsystem.entity;

import com.kyukiin.usermanagementsystem.enums.StatusCode;
import com.kyukiin.usermanagementsystem.enums.UserDepartment;
import com.kyukiin.usermanagementsystem.enums.UserSkillType;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserDepartment userDepartment;

    @Enumerated(EnumType.STRING)
    private UserSkillType userSkillType;


    private Integer grade;
    private String nickName;
    private String email;
    private String pw;
    private String name;
    private Integer age;
    private String introduction;

    @Enumerated(EnumType.STRING)
    private StatusCode statusCode;

    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;
}
