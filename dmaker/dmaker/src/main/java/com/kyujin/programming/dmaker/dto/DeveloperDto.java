package com.kyujin.programming.dmaker.dto;

import com.kyujin.programming.dmaker.entity.Developer;
import com.kyujin.programming.dmaker.type.DeveloperLevel;
import com.kyujin.programming.dmaker.type.DeveloperSkillType;
import lombok.*;

import java.util.stream.DoubleStream;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperDto {
    private DeveloperLevel developerLevel;
    private DeveloperSkillType developerSkillType;
    private String memberId;

    public static DeveloperDto fromEntity(Developer developer) {

        return DeveloperDto.builder()
                .developerLevel(developer.getDeveloperLevel())
                .developerSkillType(developer.getDeveloperSkillType())
                .memberId(developer.getMemberId())
                .build();
    }
}
