package com.kyujin.programming.dmaker.service;

import com.kyujin.programming.dmaker.dto.CreateDeveloper;
import com.kyujin.programming.dmaker.entity.Developer;
import com.kyujin.programming.dmaker.exception.DMakerErrorCode;
import com.kyujin.programming.dmaker.exception.DMakerException;
import com.kyujin.programming.dmaker.repository.DeveloperRepository;
import com.kyujin.programming.dmaker.type.DeveloperLevel;
import com.kyujin.programming.dmaker.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DMakerService {


    // @Autowired
    // @InjectService
    // 두 어노테이션 사용시 너무 어노테이션에 종속되어 버리기 떄문에
    // @RequiredArgsConstructor 를 서비스 상단에 선언하고 선언할 class 를 final 로 선언한다.
    // final 은 나중에 수정이 불가능하기 떄문에 무조건 생성자를 만들어 주어야 하므로
    // @RequiredArgsConstructor 사용시 자동으로 생성자가 만들어진다.


    private final DeveloperRepository developerRepository;

// @RequiredArgsConstructor 를 선언 후 Delombok 을 해보면 아래와 같은 생성자가 생성되어 있다.
// 예전에는 테스트에 용이한 코드를 짜기 위해서 아래와 같은 생성자를 사용하였으나 많은 클레스를 관리해야
// 할 때 비효율적이다.
// public DMakerService(DeveloperRepository developerRepository) {
//     this.developerRepository = developerRepository;
// }

    @Transactional
    public CreateDeveloper.Response createDeveloper(CreateDeveloper.Request request) {
        validateCreateDeveloperRequest(request);

        Developer developer =  Developer.builder()
                .developerLevel(request.getDeveloperLevel())
                .developerSkillType(request.getDeveloperSkillType())
                .experienceYears(request.getExperienceYears())
                .memberId(request.getMemberId())
                .name(request.getName())
                .age(request.getAge())
                .build();

        developerRepository.save(developer);
        return CreateDeveloper.Response.fromEntity(developer);
    }

    private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
        // business validation
        DeveloperLevel developerLevel = request.getDeveloperLevel();
        Integer experienceYears1 = request.getExperienceYears();
        Integer experienceYears = experienceYears1;
        DMakerErrorCode levelExperienceYearsNotMatched = DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED;
        if (developerLevel == DeveloperLevel.SENIOR
                && experienceYears < 10) {
            throw new DMakerException(levelExperienceYearsNotMatched);
        }
        if (developerLevel == DeveloperLevel.JUNGNIOR
                && (experienceYears1 < 4 || experienceYears1 > 10)) {
            throw new DMakerException(levelExperienceYearsNotMatched);
        }
        if (developerLevel == DeveloperLevel.JUNIOR && experienceYears > 4) {
            throw new DMakerException(levelExperienceYearsNotMatched);
        }

        developerRepository.findByMemberId(request.getMemberId())
                .ifPresent((developer -> {
                    throw new DMakerException(DMakerErrorCode.DUPLICATED_MEMBER_ID);
                }));

    }
}
