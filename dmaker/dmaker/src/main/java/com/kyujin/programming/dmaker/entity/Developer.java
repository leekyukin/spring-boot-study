package com.kyujin.programming.dmaker.entity;

import com.kyujin.programming.dmaker.type.DeveloperLevel;
import com.kyujin.programming.dmaker.type.DeveloperSkillType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
// 날짜를 자동으로 입력해주는 기능인 Auditing 을
// 사용하기 위해서 Entity 에 선언해야한다
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
