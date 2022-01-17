package com.kyujin.programming.dmaker.entity;

import com.kyujin.programming.dmaker.type.DeveloperLevel;
import com.kyujin.programming.dmaker.type.DeveloperSkillType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Enumerated(EnumType.STRING)
    private DeveloperLevel developerLevel;

    @Enumerated(EnumType.STRING)
    private DeveloperSkillType developerSkillType;

    private Integer experienceYears;
    private String memberId;
    private String name;
    private Integer age;

    // spring date jpa  기능중에
    // 자동으로 값을 setting 해주는 기능. 오디팅
    // 엔트리 포인트인 Application 클레스에 @EnableJpaAuditing 을 주입해줌
    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;

}
